import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.*;

public class D {

    int Checkdate(String nm, String d, int t) throws IOException {

        // Date stuff
        String x = "", y = "", z = "";
        int[] dat = new int[3];
        if (d.length() > 7 && d.length() < 11) {
            x = "";
            int i = 0;
            while (d.charAt(i) != '/') {
                x += d.charAt(i);
                i++;
            }
            i++;
            y = x;
            dat[0] = Integer.valueOf(x);
            x = "";
            while (d.charAt(i) != '/') {
                x += d.charAt(i);
                i++;
            }
            z = x;
            dat[1] = Integer.valueOf(x);
            x = "";
            x += d.charAt(i + 1);
            x += d.charAt(i + 2);
            x += d.charAt(i + 3);
            x += d.charAt(i + 4);
            dat[2] = Integer.valueOf(x);
            //

            //

            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy/HH");
            String strDate = formatter.format(date);
            String sY = "" + strDate.charAt(6) + strDate.charAt(7) + strDate.charAt(8) + strDate.charAt(9);
            String sM = "" + strDate.charAt(3) + strDate.charAt(4);
            String sD = "" + strDate.charAt(0) + strDate.charAt(1);
            String sH = "" + strDate.charAt(11) + strDate.charAt(12);
            boolean bln = true;
            if (Integer.valueOf(sY) >= dat[2]) {
                if (Integer.valueOf(sY) == dat[2]) {
                    bln = false;
                }
                if (Integer.valueOf(sM) >= dat[1]) {
                    if (Integer.valueOf(sD) >= dat[0]) {
                        if (Integer.valueOf(sH) >= t) {
                            return 2;
                        } else {
                            bln = false;
                        }
                    }
                } else if (bln) {
                    return 2;
                }
            }
            // File stuff

            //

            File f = new File("C:\\LSB/data.csv");

            File dir = new File("C:\\LSB");
            dir.mkdir();
            Path path = FileSystems.getDefault().getPath("C:\\LSB");
            Files.setAttribute(path, "dos:hidden", true);

            //
            String line = "";

            // parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("C:\\LSB/data.csv"));
            while ((line = br.readLine()) != null) // returns a Boolean value
            {
                String[] user = line.split(","); // use comma as separator
                if (Integer.valueOf(user[3]) == dat[2]) {
                    if (Integer.valueOf(user[2]) == dat[1]) {
                        if (Integer.valueOf(user[1]) == dat[0]) {
                            if (Integer.valueOf(user[4]) == t) {
                                return 4;
                            }
                        }
                    }
                }
            }
            //

            FileWriter wrtr = new FileWriter(f, true);
            wrtr.append(nm);
            wrtr.append(',');
            wrtr.append(y);
            wrtr.append(',');
            wrtr.append(z);
            wrtr.append(',');
            wrtr.append(x);
            wrtr.append(',');
            wrtr.append(String.valueOf(t));
            wrtr.append('\n');
            wrtr.close();

        } else {
            return 3;
        }

        return 1;
    }
}