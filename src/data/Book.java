package data;

import java.util.Comparator;

public class Book implements Comparable<Book>
{
	private String category;
	private String title;
	private Author author;
	private String numISBN;
	private String image;
	private String infoLink;
	
	public Book ()
	{
		
	}
	public Book (String title)
	{
		this.title=title;
	}
	public Book (String title, Author author)
	{
		this.title=title;
		this.author=author;
	}
	
	public String getCategory()
	{
		return category;
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getNumISBN()
	{
		return numISBN;
	}
	public void setNumISBN(String numISBN)
	{
		this.numISBN = numISBN;
	}
	public String getImage()
	{
		return image;
	}
	public void setImage(String image)
	{
		this.image = image;
	}
	public String getInfoLink()
	{
		return infoLink;
	}
	public void setInfoLink(String infoLink)
	{
		this.infoLink = infoLink;
	}
	@Override
	public String toString()
	{
		return "Book [category=" + category + ", title=" + title + ", authorName= " + author + ", numISBN=" + numISBN + ", image=" + image + ", infoLink="
				+ infoLink + "]";
	}
	public Author getAuthor ()
	{
		return author;
	}
	public void setAuthor(Author author)
	{
		this.author = author;
	}
//	@Override
//	public int hashCode()
//	{
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((author == null) ? 0 : author.hashCode());
//		result = prime * result + ((category == null) ? 0 : category.hashCode());
//		result = prime * result + ((image == null) ? 0 : image.hashCode());
//		result = prime * result + ((infoLink == null) ? 0 : infoLink.hashCode());
//		result = prime * result + ((numISBN == null) ? 0 : numISBN.hashCode());
//		result = prime * result + ((title == null) ? 0 : title.hashCode());
//		return result;
//	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null)
		{
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (category == null)
		{
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (image == null)
		{
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (infoLink == null)
		{
			if (other.infoLink != null)
				return false;
		} else if (!infoLink.equals(other.infoLink))
			return false;
		if (numISBN == null)
		{
			if (other.numISBN != null)
				return false;
		} else if (!numISBN.equals(other.numISBN))
			return false;
		if (title == null)
		{
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
//	@Override
//	public int compare(Book o1, Book o2)
//	{
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public int compareTo(Book o)
	{
		int titleDiff = title.compareToIgnoreCase(o.title);
		if(titleDiff != 0)
		{
			return titleDiff;
		}
		else return 0;
	}
}
