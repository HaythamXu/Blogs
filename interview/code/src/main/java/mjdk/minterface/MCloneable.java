package mjdk.minterface;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class MCloneable implements Cloneable{
}


@Getter
@Setter
class Person {
    String name;
    int age;
    List<Education> educations;
}

@Getter
@Setter
class Education {
    String schoolName;

}