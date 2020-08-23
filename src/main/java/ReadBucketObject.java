import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadBucketObject {
    public static void main(String[] args) throws IOException {

        final String bucketName="java-s3-24082020";
        final String keyName="SQS-Tutorial-20200823";

        final AmazonS3 s3= AmazonS3ClientBuilder.defaultClient();
        S3Object s3Object=s3.getObject(new GetObjectRequest(bucketName,keyName));
        InputStream objectData=s3Object.getObjectContent();

        try(BufferedReader reader=new BufferedReader(new InputStreamReader(s3Object.getObjectContent()))){
            String eachLine;
            while((eachLine=reader.readLine())!=null){
                System.out.println(eachLine);
            }
            objectData.close();
        }
    }
}
