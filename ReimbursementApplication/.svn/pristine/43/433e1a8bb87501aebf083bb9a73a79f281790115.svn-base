package com.avizva.utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.avizva.model.ReimbursementRequest;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class CreatePdf {


	private static String filePath;

	private static Font TIME_ROMAN = new Font(Font.TIMES_ROMAN, 18, Font.BOLD);
	private static Font TIME_ROMAN_SMALL = new Font(Font.TIMES_ROMAN, 12, Font.BOLD);
	private static Font TIME_ROMAN_HEADING = new Font(Font.TIMES_ROMAN, 10, Font.BOLD);
	private static Font TIME_ROMAN_VALUE = new Font(Font.TIMES_ROMAN, 10);
	/**
	 * @param args
	 */

	public static String createPdfForManager(String file, List<ReimbursementRequest> request, String filePath) {

		Document document = null;
		String fileName = (int) (Math.random() * 100000) + file;
		try {
			document = new Document(PageSize.A4.rotate());

			PdfWriter.getInstance(document, new FileOutputStream(filePath + fileName));
			document.open();

			addMetaData(document);

			addTitlePage(document);

			createTableForManager(document, request);

			document.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return fileName;

	}

	public static String createPdfForFinance(String file, List<ReimbursementRequest> request, String filePath) {

		Document document = null;
		String fileName = (int) (Math.random() * 100000) + file;
		try {
			document = new Document(PageSize.A4.rotate());

			PdfWriter.getInstance(document, new FileOutputStream(filePath + fileName));
			document.open();

			addMetaData(document);

			addTitlePage(document);

			createTableForFinance(document, request);

			document.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return fileName;

	}

	public static void addMetaData(Document document) {
		document.addTitle("Generate PDF report");
		document.addSubject("Generate PDF report");
		document.addAuthor("AVIZVA REIMBURSEMENT SYSTEM");
		document.addCreator("AVIZVA REIMBURSEMENT SYSTEM");
	}

	public static void addTitlePage(Document document) throws DocumentException {

		Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("PDF Report", TIME_ROMAN));

		creteEmptyLine(preface, 1);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		preface.add(new Paragraph("Report created on " + simpleDateFormat.format(new Date()), TIME_ROMAN_SMALL));
		document.add(preface);

	}

	public static void creteEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	public static void createTableForManager(Document document, List<ReimbursementRequest> request)
			throws DocumentException {
		Paragraph paragraph = new Paragraph();
		creteEmptyLine(paragraph, 2);
		document.add(paragraph);
		PdfPTable table = new PdfPTable(7);

		PdfPCell c1 = new PdfPCell(new Phrase("REQUEST ID", TIME_ROMAN_HEADING));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("EMPLOYEE NAME", TIME_ROMAN_HEADING));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("SUBMISSION DATE", TIME_ROMAN_HEADING));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		c1 = new PdfPCell(new Phrase("CATEGORY", TIME_ROMAN_HEADING));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		c1 = new PdfPCell(new Phrase("AMOUNT REQUESTED", TIME_ROMAN_HEADING));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		c1 = new PdfPCell(new Phrase("AMOUNT APPROVED", TIME_ROMAN_HEADING));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		c1 = new PdfPCell(new Phrase("STATUS", TIME_ROMAN_HEADING));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		for (ReimbursementRequest req : request) {
			String status = null;
			table.setWidthPercentage(100);
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(new PdfPCell(new Phrase(req.getReimbursementId(), TIME_ROMAN_VALUE)));
			table.addCell(new PdfPCell(new Phrase(
					req.getEmployee().getFirstName() + " " + req.getEmployee().getLastName(), TIME_ROMAN_VALUE)));
			table.addCell(new PdfPCell(new Phrase(req.getSubmissionDate().toString(), TIME_ROMAN_VALUE)));
			table.addCell(new PdfPCell(new Phrase(req.getCategory().getName(), TIME_ROMAN_VALUE)));
			table.addCell(new PdfPCell(new Phrase(req.getAmountRequested().toString(), TIME_ROMAN_VALUE)));
			table.addCell(new PdfPCell(new Phrase(req.getAmountApproved().toString(), TIME_ROMAN_VALUE)));
			if (req.getAmountApproved() == 0) {
				status = "REJECTED";
			} else if (req.getAmountApproved() != 0 && req.getAmountApproved() < req.getAmountRequested()) {
				status = "PARTIAL";
			} else {
				status = "APPROVED";
			}
			table.addCell(new PdfPCell(new Phrase(status, TIME_ROMAN_VALUE)));

		}

		document.add(table);
	}

	public static void createTableForFinance(Document document, List<ReimbursementRequest> request)
			throws DocumentException {
		Paragraph paragraph = new Paragraph();
		creteEmptyLine(paragraph, 2);
		document.add(paragraph);
		PdfPTable table = new PdfPTable(9);

		PdfPCell c1 = new PdfPCell(new Phrase("REQUEST ID", TIME_ROMAN_HEADING));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("EMPLOYEE NAME", TIME_ROMAN_HEADING));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("SUBMISSION DATE", TIME_ROMAN_HEADING));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		c1 = new PdfPCell(new Phrase("TYPE", TIME_ROMAN_HEADING));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		c1 = new PdfPCell(new Phrase("CATEGORY", TIME_ROMAN_HEADING));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		c1 = new PdfPCell(new Phrase("PROJECT", TIME_ROMAN_HEADING));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		c1 = new PdfPCell(new Phrase("AMOUNT REQUESTED", TIME_ROMAN_HEADING));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		c1 = new PdfPCell(new Phrase("AMOUNT APPROVED", TIME_ROMAN_HEADING));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		c1 = new PdfPCell(new Phrase("STATUS", TIME_ROMAN_HEADING));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		for (ReimbursementRequest req : request) {
			String status = null;
			table.setWidthPercentage(100);
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(new PdfPCell(new Phrase(req.getReimbursementId(), TIME_ROMAN_VALUE)));
			table.addCell(new PdfPCell(new Phrase(
					req.getEmployee().getFirstName() + " " + req.getEmployee().getLastName(), TIME_ROMAN_VALUE)));
			table.addCell(new PdfPCell(new Phrase(req.getSubmissionDate().toString(), TIME_ROMAN_VALUE)));
			table.addCell(new PdfPCell(new Phrase(req.getCategory().getType().toString(), TIME_ROMAN_VALUE)));
			table.addCell(new PdfPCell(new Phrase(req.getCategory().getName(), TIME_ROMAN_VALUE)));
			table.addCell(
					new PdfPCell(new Phrase(req.getEmployee().getAssignedToProject().getName(), TIME_ROMAN_VALUE)));
			table.addCell(new PdfPCell(new Phrase(req.getAmountRequested().toString(), TIME_ROMAN_VALUE)));
			table.addCell(new PdfPCell(new Phrase(req.getAmountApproved().toString(), TIME_ROMAN_VALUE)));
			if (req.getAmountApproved() == 0) {
				status = "REJECTED";
			} else if (req.getAmountApproved() != 0 && req.getAmountApproved() < req.getAmountRequested()) {
				status = "PARTIAL";
			} else {
				status = "APPROVED";
			}
			table.addCell(new PdfPCell(new Phrase(status, TIME_ROMAN_VALUE)));
		}

		document.add(table);
	}
}
