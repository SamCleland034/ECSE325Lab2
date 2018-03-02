import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BinaryConvertor {
	public void convert() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/lab2-x.txt"));
		BufferedReader reader2 = new BufferedReader(new FileReader("src/lab2-y.txt"));
		int weight = 10;
		int fweight = 7;
		ArrayList<Double> data = new ArrayList<Double>();
		ArrayList<Double> data2= new ArrayList<Double>();
		ArrayList<String> bstrings = new ArrayList<String>();
		ArrayList<String> bstrings2 = new ArrayList<String>();
		char[] sData = reader.readLine().toCharArray();
		StringBuilder temp = new StringBuilder();
		int i = 0;
		for (i = 0; i < sData.length; i=i) {
			while (sData[i] != ' ') {
				temp.append(sData[i]);
				i++;
			}
			data.add(Double.parseDouble(temp.toString()));
			temp.delete(0, temp.length());
			i++;
		}
		reader.close();
		char [] sData2=reader2.readLine().toCharArray();
		reader2.close();
		for (i = 0; i < sData2.length; i = i) {
			while (sData2[i] != ' ') {
				temp.append(sData2[i]);
				i++;
			}
			data2.add(Double.parseDouble(temp.toString()));
			temp.delete(0, temp.length());
			i++;
		}
		for(i = 0; i<data.size();i++) {
			boolean isPositive=false;
			if(data.get(i)>0) isPositive=true;
			int c = (int) Math.round(Math.abs(data.get(i)) * Math.pow(2, fweight));
			String value = Integer.toBinaryString(c);
			StringBuilder sb= new StringBuilder();
			sb.append('0');
			sb.append(value);
			String twosComp = sb.toString();
			
			if (!isPositive) {
				sb.delete(0, sb.length());
				boolean flip = false;
				for (int x = twosComp.length() - 1; x > -1; x--) {
					if (twosComp.charAt(x) == '1' && !flip) {
						flip = true;
						sb.insert(0, twosComp.charAt(x));

						continue;
					}
					if (flip) {
						if (twosComp.charAt(x) == '1')
							sb.insert(0, '0');
						else
							sb.insert(0, '1');
					} else
						sb.insert(0, twosComp.charAt(x));

				}

			}
			while(sb.length()<10) {
				if(isPositive)
					sb.insert(0, '0');
				else
					sb.insert(0, '1');
					
			}
			bstrings.add(sb.toString());
			sb.delete(0, sb.length());
			
		}
		for(i = 0; i<data2.size();i++) {
			boolean isPositive=false;
			if(data2.get(i)>0) isPositive=true;
			int c = (int) Math.round(Math.abs(data2.get(i)) * Math.pow(2, fweight));
			String value = Integer.toBinaryString(c);
			StringBuilder sb= new StringBuilder();
			sb.append('0');
			sb.append(value);
			String twosComp = sb.toString();
			
			if (!isPositive) {
				sb.delete(0, sb.length());
				boolean flip = false;
				for (int x = twosComp.length() - 1; x > -1; x--) {
					if (twosComp.charAt(x) == '1' && !flip) {
						flip = true;
						sb.insert(0, twosComp.charAt(x));

						continue;
					}
					if (flip) {
						if (twosComp.charAt(x) == '1')
							sb.insert(0, '0');
						else
							sb.insert(0, '1');
					} else
						sb.insert(0, twosComp.charAt(x));

				}

			}
			while(sb.length()<10) {
				if(isPositive)
					sb.insert(0, '0');
				else
					sb.insert(0, '1');
					
			}
			bstrings2.add(sb.toString());
			sb.delete(0, sb.length());
			
		}
		StringBuilder outputText= new StringBuilder();
		for (i = 0; i < bstrings.size(); i++) {
			outputText.append(bstrings.remove(0));
			outputText.append(System.lineSeparator());
		}
		StringBuilder outputText2= new StringBuilder();
		for (i = 0; i < bstrings2.size(); i++) {
			outputText2.append(bstrings2.remove(0));
			outputText2.append(System.lineSeparator());
		}
		File lab2output = new File("src", "lab2-x-fixed-point.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(lab2output));
		bw.write(outputText.toString());
		bw.close();
		File lab2output2= new File("src", "lab2-y-fixed-point.txt");
		BufferedWriter bw2= new BufferedWriter(new FileWriter(lab2output2));
		bw2.write(outputText2.toString());
		bw2.close();
		System.exit(0);
		
	}
}
