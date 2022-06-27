#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.framework.api;

public class ApiPath {
    private ApiPath() {}

    public static class HelloWorld {
        private HelloWorld(){}
        public static final String BASE = "/hello/world";

        public static final String GREETING = "/greeting";
    }

    public static class Something {
        private Something(){}
        public static final String BASE = "/something";

        public static final String SOME_RESOURCE = "/some-resource";
    }

    public static class Administration {
        private Administration() {}
        public static final String BASE = "/administration";

        public static final String EMPLOYEE = "/employee";

    }
}
