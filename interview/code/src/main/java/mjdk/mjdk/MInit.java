package mjdk.mjdk;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MInit {

    private int int1;
    private String string1;
    private List<String> stringList1;

    public static void main(String[] args) {
        String innerString;
        SampleClass sampleClass = new SampleClass();
        System.out.println(sampleClass.getWithoutInit());
        System.out.println(sampleClass.getWithInit());
    }

}

@Data
class SampleClass {

    private static String staticString;
    private String withoutInit;
    private String withInit = "init string";
}
