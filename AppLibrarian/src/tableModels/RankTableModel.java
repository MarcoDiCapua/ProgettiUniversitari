package tableModels;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import dataModel.Book;
import dataModel.Category;

/**
 * This class is a definition of DefaultTableModel that store in the cell all
 * books rank information. The rows shown by this model are 25 per pages.
 * 
 * @author Marco Di Capua
 * @author Mattia Lo Schiavo
 * @author Filippo Pelosi
 * @author Riccardo Zorzi
 * @version 1.0
 */
public class RankTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	private static final String[] HEADER = { "Posizione", "Titolo", "Autori", "ISBN", "Categoria", "Lingua",
			"Anno pubblicazione", "Anno ristampa", "Casa editrice", "Scaffale" };
	private ArrayList<Book> books;

	/**
	 * Create a new object <code>AlBooksTableModel</code> with the informations
	 * contains in the books list
	 * 
	 * @param books
	 *            the list contains the books to be shown
	 */
	public RankTableModel(ArrayList<Book> books) {
		super();
		this.books = books;
	}

	/**
	 * Returns the number of columns in this data table
	 * 
	 * @return the number of columns in the model
	 */
	@Override
	public int getColumnCount() {
		return HEADER.length;
	}

	/**
	 * Returns the number of rows in this data table.
	 * 
	 * @return the number of rows in the model
	 */
	@Override
	public int getRowCount() {
		if (this.books == null) {
			return 0;
		} else {
			return books.size();
		}
	}

	/**
	 * Returns an attribute value for the cell at row and column.
	 * 
	 * @param row
	 *            the row whose value is to be queried
	 * @param column
	 *            the column whose value is to be queried
	 * @return the value Object at the specified cell
	 */
	@Override
	public Object getValueAt(int row, int column) {
		Book book = this.books.get(row);
		switch (column) {
		case 0:
			return row + 1;
		case 1:
			return book.getTitle();
		case 2:
			return book.getAuthors();
		case 3:
			return book.getIsbn();
		case 4:
			return book.getCategory();
		case 5:
			return book.getLanguage();
		case 6:
			return book.getPublicationYear();
		case 7:
			return book.getReprintYear();
		case 8:
			return book.getPublishingHouse();
		case 9:
			return book.getBookcase();
		}

		return null;
	}

	/**
	 * the class of the given column, or Object.class if the column doesn't exist
	 * 
	 * @param columnIndex
	 *            the column index
	 * @return the column class
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return Category.class;
		case 5:
			return String.class;
		case 6:
			return String.class;
		case 7:
			return String.class;
		case 8:
			return String.class;
		case 9:
			return String.class;
		}
		return Object.class;
	}

	/**
	 * Returns the column name
	 * 
	 * @param column
	 *            the column being queried
	 * @return column name or null if the column doesn't exist
	 */
	@Override
	public String getColumnName(int column) {
		if (column > -1 && column < HEADER.length) {
			return HEADER[column];
		} else {
			return null;
		}
	}

	/**
	 * Returns false regardless of parameter values.
	 * 
	 * @param rowIndex
	 *            the row whose value is to be queried
	 * @param columnIndex
	 *            the column whose value is to be queried
	 * @return false
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

}
