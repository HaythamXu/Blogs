package mjdk.mexception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MLogging {

    private static java.util.logging.Logger JDK_LOGGER = java.util.logging.Logger.getGlobal();
    private static Log APACHE_LOG = LogFactory.getLog(MLogging.class);
    private static Logger SLF4J_LOGGER = LoggerFactory.getLogger(MLogging.class);

    // 使用getClass()而不是类名，可以在子类继承时直接调用
    private org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(getClass());

    public static void testJdkLogger() {
        MLogging.JDK_LOGGER.severe("jdk logger sever");
        MLogging.JDK_LOGGER.warning("jdk logger warning");
        MLogging.JDK_LOGGER.info("jdk logger info");
        // -----default-----
        MLogging.JDK_LOGGER.config("jdk logger config");
        MLogging.JDK_LOGGER.fine("jdk logger fine");
        MLogging.JDK_LOGGER.finer("jdk logger finer");
        MLogging.JDK_LOGGER.finest("jdk logger finest");
    }

    public static void testApacheLog() {
        RuntimeException e = new RuntimeException("runtime exception");
        MLogging.APACHE_LOG.fatal("commons logging fatal", e);
        MLogging.APACHE_LOG.error("commons logging error", e);
        MLogging.APACHE_LOG.warn("commons logging warning");
        MLogging.APACHE_LOG.info("commons logging info");
        // ----default-----
        MLogging.APACHE_LOG.debug("commons logging debug");
        MLogging.APACHE_LOG.trace("commons logging trace");
    }

    public static void testSlf4jLogger() {
        MLogging.SLF4J_LOGGER.error("slf4j logger error");
        MLogging.SLF4J_LOGGER.warn("slf4j logger warn");
        MLogging.SLF4J_LOGGER.info("slf4j logger info");
        // -------default----
        MLogging.SLF4J_LOGGER.debug("slf4j logger debug");
        MLogging.SLF4J_LOGGER.trace("slf4j logger trace");
    }

    public static void main(String[] args) {
        MLogging.testJdkLogger();
        MLogging.testApacheLog();
        MLogging.testSlf4jLogger();
    }
}
