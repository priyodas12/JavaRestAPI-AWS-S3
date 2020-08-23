import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;


import java.util.List;

public class ListOfObjectsInBucket {
    public static void main(String[] args)  {
        final AmazonS3 s3= AmazonS3ClientBuilder.defaultClient();
        final String bucketName="java-s3-24082020";

        ObjectListing ol=s3.listObjects(bucketName);

        List<S3ObjectSummary> listOfObjects=ol.getObjectSummaries();

        listOfObjects.forEach(i-> System.out.println(i.getKey()));
    }
}
