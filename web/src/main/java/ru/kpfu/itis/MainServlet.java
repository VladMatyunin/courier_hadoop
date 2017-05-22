package ru.kpfu.itis;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.net.URL;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.web.URLConnectionFactory;

/**
 * Created by vladislav on 22.05.17.
 */
public class MainServlet extends HttpServlet{
    private Configuration conf;
    private FileSystem fileSystem;

    @Override
    public void init() throws ServletException {
        super.init();
        conf = new Configuration();
        try {
            fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000/user/hduser/out/part-r-00000"), conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        InputStream stream = null;

        try {
            stream = fileSystem.open(new Path("hdfs://localhost:9000/user/hduser/out/part-r-00000"));
            StringWriter writer = new StringWriter();
            IOUtils.copy(stream, writer,"UTF-8");
            String theString = writer.toString();
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter writer1 = resp.getWriter();
            writer1.append(theString);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
