import java.io.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Provide input and output file names. ex: java Main input.txt output.txt");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        LazyBinarySearchTree tree = new LazyBinarySearchTree();

        try (BufferedReader rd = new BufferedReader(new FileReader(inputFile));
             PrintWriter wt = new PrintWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = rd.readLine()) != null) {
                try {
                    executeLine(tree, line, wt);
                } catch (IllegalArgumentException e) {
                    wt.println("Error in " + line + ": " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }

    private static void executeLine(LazyBinarySearchTree tree, String line, PrintWriter writer) {
        if (line.startsWith("Insert:")) {
            int key = Integer.parseInt(line.substring(7));
            boolean result = tree.insert(key);
            writer.println(result);
            
        } else if (line.startsWith("Delete:")) {
            int key = Integer.parseInt(line.substring(7));
            boolean result = tree.delete(key);
            writer.println(result);
            
        } else if (line.startsWith("Contains:")) {
            int key = Integer.parseInt(line.substring(9));
            boolean result = tree.contains(key);
            writer.println(result);
            
        } else if (line.equals("FindMin")) {
            int min = tree.findMin();
            writer.println(min);
            
        } else if (line.equals("FindMax")) {
            int max = tree.findMax();
            writer.println(max);
            
        } else if (line.equals("PrintTree")) {
            writer.println(tree.toString());
            
        } else if (line.equals("Height")) {
            int height = tree.height();
            writer.println(height);
            
        } else if (line.equals("Size")) {
            int size = tree.size();
            writer.println(size);
            
        } else {
            writer.println("Error in Line: " + line);
        }
    }
}