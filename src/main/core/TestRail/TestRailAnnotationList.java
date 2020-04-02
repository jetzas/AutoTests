package core.TestRail;


import java.lang.annotation.*;

@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface TestRailAnnotationList {


	int[] TestCaseIds();

}
