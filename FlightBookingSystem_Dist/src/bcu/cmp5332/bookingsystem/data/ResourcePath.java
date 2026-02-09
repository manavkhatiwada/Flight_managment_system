package bcu.cmp5332.bookingsystem.data;

import java.io.File;
import java.nio.file.Paths;

/**
 * Utility class to find resource files in various working directory contexts
 */
public class ResourcePath {

    private static final String[] POSSIBLE_PARENTS = {
        "",
        "FlightBookingSystem_Dist",
        "FlightBookingSystem_final\\FlightBookingSystem_Dist",
        "FlightBookingSystem_final/FlightBookingSystem_Dist"
    };

    private static final String[] POSSIBLE_ROOTS = {
        ".",
        "./resources",
        "resources",
        "..\\..",
        "../../"
    };

    /**
     * Find the data file in any of the possible locations
     * @param filename The name of the file (e.g., "flights.txt")
     * @return The path to the file that exists, or default path if none found
     */
    public static String getDataFilePath(String filename) {
        // Try to find the resources folder from current working directory

        // First, try direct paths
        String[] directPaths = {
            "resources/data/" + filename,
            "./resources/data/" + filename,
            "FlightBookingSystem_Dist/resources/data/" + filename,
            "..\\resources\\data\\" + filename,
            "../../resources/data/" + filename
        };

        for (String path : directPaths) {
            File file = new File(path);
            if (file.exists()) {
                return path;
            }
        }

        // Try to find resources from the jar location or source location
        try {
            String userDir = System.getProperty("user.dir");
            String[] searchPaths = {
                userDir + "/resources/data/" + filename,
                userDir + "\\resources\\data\\" + filename,
                userDir + "/FlightBookingSystem_Dist/resources/data/" + filename,
                userDir + "\\FlightBookingSystem_Dist\\resources\\data\\" + filename,
                new File(userDir).getParent() + "/resources/data/" + filename,
                new File(userDir).getParent() + "\\resources\\data\\" + filename
            };

            for (String path : searchPaths) {
                if (path != null) {
                    File file = new File(path);
                    if (file.exists()) {
                        return path;
                    }
                }
            }
        } catch (Exception e) {
            // If something goes wrong, fall through to default
        }

        // Default fallback
        return "resources/data/" + filename;
    }

    /**
     * Ensure the resources/data directory exists
     */
    public static void ensureResourceDirectoryExists() {
        File dir = new File("resources/data");
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
}

