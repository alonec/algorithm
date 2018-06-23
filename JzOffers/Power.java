public class Power {
	 /*
	  *  �˷����⣺����һ��double���͵ĸ�����base��int���͵�����exponent��
	  *  ��base��exponent�η���
	  */
	
	public static double solution01(double base, int exponent) {
    	/*
    	 * ����1�����㷨
    	 * ʱ�临�Ӷȣ�O(n)
    	 * ����ʱ�䣺 51 ms ռ���ڴ棺10568K
    	 */
    	
    	double result = 1.0;
    	if(base == 0)	// 0������η���Ϊ0
    		return 0;
    	if(base == 1 || exponent == 0) // 1�����������η�������1������0���κ�����0�η�������1
    		return 1;
    	if(exponent == 0) 
    		return 1;
    	
    	// �ж�exponent������
    	if(exponent >= 0) {
    		for(int i=0; i<exponent; ++i) {  // �۳�
    			result *= base;
    		}
    		return result;
    	}
    	else {
    		exponent *= -1;
    		for(int i=0; i<exponent; ++i) {  // �۳�
    			result *= base;
    		}
    		return 1.0/result;
    	}
        
    }
	public static double solution(double base, int exponent) {
    	/*
    	 * ����2�����η�����˷�����
    	 * 			ifָ����ż�� ��base^exponent = base^(exponent/2)*base^(exponent/2)
    	 * 			ifָ�������� ��base^exponent = base^(exponent/2)*base^(exponent/2)*base
    	 * ʱ�临�Ӷȣ�O(lgn)
    	 * ����ʱ�䣺59ms	ռ���ڴ棺10604k
    	 */
		double result = 1.0;
    	if(base == 0)	// 0������η���Ϊ0
    		return 0;
    	if(base == 1 || exponent == 0) // 1�����������η�������1������0���κ�����0�η�������1
    		return 1;
    	if(exponent == 0) 
    		return 1;
    	// �ж�exponent������
    	if(exponent >= 0) {
    		if(exponent % 2 == 0) { // ż���η�
    			result = solution(base, exponent/2);// ����ȡ��
    			result *= result;
    		}else{	// �����η�
    			result = solution(base, exponent/2);// ����ȡ��
    			result = result * result * base;  		
    		}
    		
    		return result;
    	}else {
    		exponent *= -1;
    		if(exponent % 2 == 0) { // ż���η�
    			result = solution(base, exponent/2);// ����ȡ��
    			result *= result;
    		} else{	// �����η�
    			result = solution(base, exponent/2);// ����ȡ��
    			result = result * result * base;  		
    		}
    		return 1.0/result;
    	}
		
	}
	public static void main(String[] args) {
	
		System.out.println(solution(-3, -1));

	}

}
