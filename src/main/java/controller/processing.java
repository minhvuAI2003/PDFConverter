package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.pdfbox.pdmodel.PDDocument;

import org.apache.pdfbox.text.PDFTextStripper;

import org.apache.poi.xwpf.usermodel.*;

import java.io.*;

/**
 * Servlet implementation class processing
 */
@WebServlet("/processing")
public class processing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public processing() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (!session.getAttribute("check").equals("check")) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
			String pdfFilePath = request.getParameter("tenfile");
			String docxFilePath = request.getParameter("tenfile1");
			if (!pdfFilePath.substring(pdfFilePath.length() - 3, pdfFilePath.length()).equals("pdf")) {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			if (!docxFilePath.substring(docxFilePath.length() - 4, docxFilePath.length()).equals("docx")) {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			try {

				convertPdfToDocx(pdfFilePath, docxFilePath);
				request.setAttribute("link", docxFilePath);
				request.getRequestDispatcher("/result.jsp").forward(request, response);
				System.out.println("Conversion completed successfully.");

			} catch (IOException e) {

				System.out.println("Error occurred while converting the file: " + e.getMessage());

			}

		}
	}

	public static void convertPdfToDocx(String pdfFilePath, String docxFilePath) throws IOException {

		// Load PDF document

		File pdfFile = new File(pdfFilePath);

		PDDocument pdDocument = PDDocument.load(pdfFile);

		// Read text content from PDF

		PDFTextStripper textStripper = new PDFTextStripper();

		String textContent = textStripper.getText(pdDocument);

		// Create new DOCX document and paragraph

		XWPFDocument docxDocument = new XWPFDocument();

		XWPFParagraph paragraph = docxDocument.createParagraph();

		// Set font and alignment properties

		XWPFRun run = paragraph.createRun();

		run.setFontFamily("Times New Roman");

		run.setFontSize(12);

		paragraph.setAlignment(ParagraphAlignment.LEFT);

		// Split text content by newlines to maintain paragraph formatting

		String[] lines = textContent.split("\\r?\\n");

		for (String line : lines) {

			// Insert line breaks between paragraphs

			if (!line.isEmpty()) {

				run.setText(line);

				run.addBreak();

			}

		}

		// Save DOCX document to file

		FileOutputStream fos = new FileOutputStream(new File(docxFilePath));

		docxDocument.write(fos);

		// Close resources

		pdDocument.close();

		docxDocument.close();

		fos.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
