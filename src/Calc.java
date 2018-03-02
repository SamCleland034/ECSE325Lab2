import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Calc {

	public static void main(String[] args) throws IOException {
		BinaryConvertor bc= new BinaryConvertor();
		bc.convert();
		
		BufferedReader reader = new BufferedReader(new FileReader("src/lab2-x.txt"));
		BufferedReader reader2 = new BufferedReader(new FileReader("src/lab2-y.txt"));
		while (!reader.ready())
			;
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
		
		// ArrayList<String> strings=decimalToBinary(data);
		for (i = 0; i < (data.size()); i++) {
			Double fweight = (double) 0;
			int j = 0;
			String curr = data.get(i).toString();
			//////System.out.println("Number is: " + curr);
			while (curr.charAt(j) != '.') {
				j++;
			}
			if (curr.charAt(0) == '-')
				fweight = (double) (curr.length() - j - 1);
			else
				fweight = (double) (curr.length() - j - 1);
			//////System.out.println("Fraction is : " + fweight);
			boolean isPositive = data.get(i) > 0;
			int weight = (int) Math.round(Math.abs(data.get(i)) * Math.pow(2, fweight));
			String value = Integer.toBinaryString(weight);
			//////System.out.println("Value is: " + value);
			StringBuilder vb = new StringBuilder();
			vb.append('0');
			vb.append(value);
			String twosComp = vb.toString();
			
			if (!isPositive) {
				vb.delete(0, vb.length());
				boolean flip = false;
				for (int x = twosComp.length() - 1; x > -1; x--) {
					if (twosComp.charAt(x) == '1' && !flip) {
						flip = true;
						vb.insert(0, twosComp.charAt(x));

						continue;
					}
					if (flip) {
						if (twosComp.charAt(x) == '1')
							vb.insert(0, '0');
						else
							vb.insert(0, '1');
					} else
						vb.insert(0, twosComp.charAt(x));

				}

			}
			while(vb.length()<10) {
				if(isPositive)
					vb.insert(0, '0');
				else
					vb.insert(0, '1');
			}
			/*int diff = (int)(twosComp.length() -  fweight);
			if (diff >= 0)
				vb.insert(diff, '.');
			else {
				int y;
				for ( y = diff; y <= diff; y++) {
					if (isPositive)
						vb.insert(0, '0');
					else
						vb.insert(0, '1');
				}
				vb.insert(0, '.');
			}
			if (vb.toString().charAt(0) == '.') {
				if (isPositive)
					vb.insert(0, '0');
				else
					vb.insert(0, '1');

			}*/
			bstrings.add(vb.toString());
			vb.delete(0, vb.length());

			// bstrings.add(Integer.toBinaryString((((int) (data.remove(0) *
			// data.remove(1))))));
		}
		for (i = 0; i < (data2.size()); i++) {
			Double fweight = (double) 0;
			int j = 0;
			String curr = data2.get(i).toString();
			//////System.out.println("Number is: " + curr);
			while (curr.charAt(j) != '.') {
				j++;
			}
			if (curr.charAt(0) == '-')
				fweight = (double) (curr.length() - j - 1);
			else
				fweight = (double) (curr.length() - j - 1);
			//////System.out.println("Fraction is : " + fweight);
			boolean isPositive = data2.get(i) > 0;
			int weight = (int) Math.round(Math.abs(data2.get(i)) * Math.pow(2, fweight));
			String value = Integer.toBinaryString(weight);
			//////System.out.println("Value is: " + value);
			StringBuilder vb = new StringBuilder();
			vb.append('0');
			vb.append(value);
			String twosComp = vb.toString();
			
			if (!isPositive) {
				vb.delete(0, vb.length());
				boolean flip = false;
				for (int x = twosComp.length() - 1; x > -1; x--) {
					if (twosComp.charAt(x) == '1' && !flip) {
						flip = true;
						vb.insert(0, twosComp.charAt(x));

						continue;
					}
					if (flip) {
						if (twosComp.charAt(x) == '1')
							vb.insert(0, '0');
						else
							vb.insert(0, '1');
					} else
						vb.insert(0, twosComp.charAt(x));

				}

			}
			while(vb.length()<10) {
				if(isPositive)
					vb.insert(0, '0');
				else
					vb.insert(0, '1');
			}
			/*int diff = (int)(twosComp.length() -  fweight);
			if (diff >= 0)
				vb.insert(diff, '.');
			else {
				int y;
				for ( y = diff; y <= diff; y++) {
					if (isPositive)
						vb.insert(0, '0');
					else
						vb.insert(0, '1');
				}
				vb.insert(0, '.');
			}
			if (vb.toString().charAt(0) == '.') {
				if (isPositive)
					vb.insert(0, '0');
				else
					vb.insert(0, '1');

			}*/
			bstrings2.add(vb.toString());
			vb.delete(0, vb.length());

			// bstrings.add(Integer.toBinaryString((((int) (data.remove(0) *
			// data.remove(1))))));
		}
		StringBuilder outputText= new StringBuilder();
		for (i = 0; i < bstrings.size(); i++) {
			outputText.append(bstrings.remove(0));
			outputText.append(System.lineSeparator());
		}
		int maxW=0;
		int curr;
		/*for(i=0;i<bstrings.size();i++) {
			curr= bstrings.get(i).length();
			if(curr>maxW) maxW = curr;
		}*/
	//	maxW-=1;
		int maxF=0;
		String[] array;
	/*	for(i=0;i<bstrings.size();i++) {
			array=bstrings.get(i).split(Pattern.quote("."));
			curr=array[1].length();
			if (curr>maxF) maxF=curr;
		}*/
		StringBuilder outputText2= new StringBuilder();
		for (i = 0; i < bstrings2.size(); i++) {
			outputText2.append(bstrings2.remove(0));
			outputText2.append(System.lineSeparator());
		}
		int maxW2=0;
		int curr2;
		/*for(i=0;i<bstrings2.size();i++) {
			curr2= bstrings2.get(i).length();
			if(curr2>maxW2) maxW2 = curr2;
		}*/
		//maxW2-=1;
		int maxF2=0;
		String[] array2;
	/*	for(i=0;i<bstrings2.size();i++) {
			array2=bstrings2.get(i).split(Pattern.quote("."));
			curr2=array2[1].length();
			if (curr2>maxF2) maxF2=curr2;
		}*/
		//outputText.append(" Max W is: " +maxW + "\n");
	//	outputText.append("\n Max F is: " + maxF + "\n");
	//	outputText2.append("\n Max W is: " +maxW2 + "\n");
	//	outputText2.append("\n Max F is: " + maxF2 + "\n");
		File lab2output = new File("src", "lab2-x-fixed-point.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(lab2output));
		bw.write(outputText.toString());
		bw.close();
		File lab2output2= new File("src", "lab2-y-fixed-point.txt");
		BufferedWriter bw2= new BufferedWriter(new FileWriter(lab2output2));
		bw2.write(outputText2.toString());
		bw2.close();
		/*
		 * FileOutputStream fo = new FileOutputStream(lab2output); char[] bytes =
		 * outputText.toCharArray(); for ( i = 0; i < bytes.length; i++) {
		 * fo.write(bytes[i]); } fo.close();
		 */
	}

	private static void calcMAC() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/lab2-x.txt"));
		BufferedReader reader2 = new BufferedReader(new FileReader("src/lab2-y.txt"));
		while (!reader.ready())
			;
		ArrayList<Double> data = new ArrayList<Double>();
		ArrayList<Double> data2= new ArrayList<Double>();
		ArrayList<String> bstrings = new ArrayList<String>();
		ArrayList<String> bstrings2 = new ArrayList<String>();
		char[] sData = reader.readLine().toCharArray();
		StringBuilder temp = new StringBuilder();
		int i = 0;
		for (i = 0; i < sData.length; i = i) {
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
		Double mac=0.0;
		for(i = 0; i<1000; i++) {
			mac+= data.get(i)*data2.get(i);
		}
		String curr = mac.toString();
		Double fweight = (double) 0;
		int j = 0;
		//////System.out.println("Number is: " + curr);
		while (curr.charAt(j) != '.') {
			j++;
		}
		if (curr.charAt(0) == '-')
			fweight = (double) (curr.length() - j - 1);
		else
			fweight = (double) (curr.length() - j - 1);
		//////System.out.println("Fraction is : " + fweight);
		boolean isPositive = mac > 0;
		int weight = (int) Math.round(Math.abs(mac) * Math.pow(2, fweight));
		String value = Integer.toBinaryString(weight);
		//////System.out.println("Value is: " + value);
		StringBuilder vb = new StringBuilder();
		vb.append('0');
		vb.append(value);
		String twosComp = vb.toString();
		
		if (!isPositive) {
			vb.delete(0, vb.length());
			boolean flip = false;
			for (int x = twosComp.length() - 1; x > -1; x--) {
				if (twosComp.charAt(x) == '1' && !flip) {
					flip = true;
					vb.insert(0, twosComp.charAt(x));

					continue;
				}
				if (flip) {
					if (twosComp.charAt(x) == '1')
						vb.insert(0, '0');
					else
						vb.insert(0, '1');
				} else
					vb.insert(0, twosComp.charAt(x));

			}

		}
		int diff = (int)(twosComp.length() -  fweight);
		if (diff >= 0)
			vb.insert(diff, '.');
		else {
			int y;
			for ( y = diff; y <= diff; y++) {
				if (isPositive)
					vb.insert(0, '0');
				else
					vb.insert(0, '1');
			}
			vb.insert(0, '.');
		}
		if (vb.toString().charAt(0) == '.') {
			if (isPositive)
				vb.insert(0, '0');
			else
				vb.insert(0, '1');

		}
		bstrings2.add(vb.toString());
		//vb.delete(0, vb.length());
		//System.out.println("Value is: " + vb.toString());
		//System.out.println("Weight is: " + vb.length());
		diff= vb.length()-diff;
		//System.out.println("Fraction is: " +diff );
		return;
		
	}

}
