import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Searcher {

    IndexSearcher indexSearcher;
    QueryParser queryParser;
    Query query;

    public Searcher(String IndexLoc) throws IOException
    {
        File f = new File(IndexLoc);
        Directory indexDirectory =
                FSDirectory.open(f.toPath());
        IndexReader reader = DirectoryReader.open(indexDirectory);
        indexSearcher = new IndexSearcher(reader);
        queryParser = new QueryParser("contents", new StandardAnalyzer());
    }

    public TopDocs search(String searchQuery) throws IOException, ParseException
    {
        query = queryParser.parse(searchQuery);
        return indexSearcher.search(query, 10);
    }

    public Document getDocument(ScoreDoc scoreDoc) throws CorruptIndexException, IOException
    {
        return indexSearcher.doc(scoreDoc.doc);
    }
}