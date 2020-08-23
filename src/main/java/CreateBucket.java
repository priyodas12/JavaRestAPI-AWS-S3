import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//make sure bucket is empty;
public class CreateBucket {
    public static void main(String[] args) {
        final AmazonS3 s3= AmazonS3ClientBuilder.defaultClient();
        final String bucketName="java-s3-24082020";
        try{
            s3.createBucket(bucketName);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
