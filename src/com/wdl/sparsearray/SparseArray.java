package com.wdl.sparsearray;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * 
 * @ClassName: SparseArray
 * @Description: 稀疏数组
 * @author: fuling
 * @date: 2020年7月28日 上午10:30:39
 */
public class SparseArray {
	
	private int[][] sparseArray;
	private final int spareseColCount = 3;
	
	public SparseArray toSparseArray(int[][] originArray) {
		int originArrayEffectiveValueCount = getOriginArrayEffectiveValueCount(originArray);
		sparseArray = new int[originArrayEffectiveValueCount + 1][spareseColCount];
		initSparseArray(originArray, originArrayEffectiveValueCount);
		return this;
	}
	
	public SparseArray readFromDisk(){
		
		InputStream input = null;
		
		ObjectInputStream objReader = null;
		
		try {
			input = new FileInputStream("C:\\txxt\\sparse.txt");
			objReader = new ObjectInputStream(input);
			this.sparseArray = (int[][]) objReader.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				objReader.close();
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return this;
	}
	
	public int[][] toOriginArray(){
		int[][] originArray = new int[sparseArray[0][0]][sparseArray[0][1]];
		initOriginArray(originArray);
		return originArray;
	}
	
	public boolean writeToDisk() {
		
		OutputStream out = null;
		ObjectOutputStream objWriter = null;
		try {
			out = new FileOutputStream("C:\\txxt\\sparse.txt");
			objWriter = new ObjectOutputStream(out);
			objWriter.writeObject(sparseArray);
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				objWriter.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	private boolean initSparseArray(int[][] originArray, int effectiveValueCount) {
		sparseArray[0][0] = originArray.length;
		sparseArray[0][1] = originArray[0].length;
		sparseArray[0][2] = effectiveValueCount;
		
		int effectiveValueCountStartIndex = 1;
		for(int i = 0; i < sparseArray[0][0]; i++) {
			for(int j = 0; j < sparseArray[0][1]; j++) {
				if(originArray[i][j] != 0) {
					//System.out.println(originArray[i][j]);
					sparseArray[effectiveValueCountStartIndex][0] = i;
					sparseArray[effectiveValueCountStartIndex][1] = j;
					sparseArray[effectiveValueCountStartIndex][2] = originArray[i][j];
					effectiveValueCountStartIndex++;
				}
			}
		}
		
		return true;
	}
	
	private int getOriginArrayEffectiveValueCount(int[][] originArray) {
		int count = 0;
		for(int[] row : originArray) {
			for(int item : row) {
				if(item != 0)count++;
			}
		}
		return count;
	}
	
	private boolean initOriginArray(int[][] originArray) {
		int length = sparseArray.length;
		for(int i = 1; i < length ; i++) {
			originArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}
		return true;
	}
}
