import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

import java.util.List;

public class ListOfBuckets {
    public static void main(String[] args) {
        final AmazonS3 s3= AmazonS3ClientBuilder.defaultClient();
        List<Bucket> buckets=s3.listBuckets();
        System.out.println("List of all AWS buckets here:\n");
        buckets.forEach(i-> System.out.println(i.getName()+" created on "+i.getCreationDate()));
    }
}
