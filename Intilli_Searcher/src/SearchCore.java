import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

//GIVE THE SEARCH QUERY AND SEARCH HITS ARE RETURNED
public class SearchCore {

    String indexLocation = "D:\\TU\\RD\\Indexed_Files";

    public static void main(String[] args)
    {
        SearchCore Core;
        Core = new SearchCore();
        Core.Search();
    }

    public void Search()
    {
        try
        {
            Searcher searcher;
            searcher = new Searcher(indexLocation);
            System.out.println("Working as intended...");
            TopDocs hits = searcher.search("continue");

            for (ScoreDoc scoreDoc : hits.scoreDocs) {
                Document doc = searcher.getDocument(scoreDoc);
                System.out.println("File: " + doc.get("filepath"));
            }
        }
        catch (IOException e)
        {
            String message = e.getMessage();
            System.out.println(message);
        }
        catch (ParseException e)
        {
            String message = e.getMessage();
            System.out.println(message);
        }
    }
}
