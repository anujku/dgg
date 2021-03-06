package com.g2one.gtunes

class Song implements Serializable {

    static searchable = [only: ['genre', 'title']]

	Date dateCreated
	Date lastUpdated

	String file
    String title
	String genre
	Integer year
	Integer trackNumber
    Integer duration
	Album album
	Artist artist

    static constraints = {
		title blank:false
        duration(min:1)
		year range:1900..2100		
		file validator:{ val ->
			if(!new File(val).exists())
				return "song.does.not.exist"
		}
    }

	static mapping = {
		file type:"text"
	}

	static optionals = ['genre', 'year', 'trackNumber']
	
	String toString() { title }
}

