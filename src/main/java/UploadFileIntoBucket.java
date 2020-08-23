import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;


import java.io.File;
import java.io.FileNotFoundException;

public class UploadFileIntoBucket {
    public static void main(String[] args) throws FileNotFoundException {
        final AmazonS3 s3= AmazonS3ClientBuilder.defaultClient();
        //bucket name
        final String bucketName="java-s3-24082020";
        //file name in aws bucket
        final String keyName="SQS-Tutorial-20200823";
        //local file path
        final String filePath="C:\\Users\\Priyo\\Desktop\\SQS.txt";

        try {
            s3.putObject(bucketName, keyName, new File(filePath));
        }catch (AmazonServiceException  e){
            System.out.println(e.getErrorMessage());
        }

    }
}
