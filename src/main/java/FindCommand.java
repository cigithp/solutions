import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * implement find command
 *
 * find /some/dir -name "*.txt"
 * find /some/dir -size 512+
 * find /some/dir -sizeRange 1GB-4GB
 *
 * i/p: location, parameter, value
 * o/p: list of files
 */

public class FindCommand {

    class InvalidParameterException extends Exception {
        public InvalidParameterException(String message) {
            super(message);
        }
    }

    class InvalidLocationException extends Exception {
        public InvalidLocationException(String message) {
            super(message);
        }
    }

    private Map<String, String> parametersFormatMap;

    public FindCommand(Map<String, String> parametersFormatMap) {
        this.parametersFormatMap = parametersFormatMap;
    }

    private boolean isValidParameter(String parameter, String value) {
        return parametersFormatMap.containsKey(parameter)
                && parametersFormatMap.get(parameter).equals(value);
    }

    private boolean isValidLocation(String location) {
        return location.startsWith("/");
    }

    private boolean finderTask(String location) {
        Path path = Paths.get(location);
        if(!Files.isDirectory(path)) {
            //file
        }
        return false;
    }

    public List<String> find(String location, String parameter, String value) throws InvalidParameterException, InvalidLocationException {
        if(!isValidParameter(parameter, value))
            throw new InvalidParameterException("Invalid Parameter");
        if(!isValidLocation(location))
            throw new InvalidLocationException("Invalid Location");
        List<String> fileList = new ArrayList<>();
        //dfs
        return fileList;
    }

    public static void main(String[] args) {
        FindCommand findCommand = new FindCommand(new HashMap<>());
        List<String> result = null;
        try {
            result = findCommand.find("", "", "");
        } catch (InvalidParameterException | InvalidLocationException e) {
            e.printStackTrace();
        }
        System.out.println("Result: "+result);
    }

}
