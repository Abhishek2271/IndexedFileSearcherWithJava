# Indexed File Searcher

The application that reads the Lucene Index and can perform search operations on the index.

User can provide a search term and the application will return document hits based on the indexed documents.
The results in this case are the names of the matched document.

Input:

    - Index location
    - Search term

Output:
  
    - Names of the document with the search term.
    
Types of search terms supported:

    - Simple term search,
    - Proximity searches 
      e.g. "term1 term2"~10
        Searches for term1 and term2 within atmost 10 word distance with each other,
    - Wildcard searches 
      e.g.  ter* searches for anything beginning with ter, 
        *ter searches for anything ending with ter respectively
    - Phrase search 
       e.g. "This is a phrase"
        Searches for "This is a phrase" exactly

Compatibality:
  - Lucene version 7.4.0 (Indexes created from older versions are also supported)
  - Java version 10 (Backward Compatible)
