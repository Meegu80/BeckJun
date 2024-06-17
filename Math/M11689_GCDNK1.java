package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class M11689_GCDNK1 {
    public static void main(String[] args) throws IOException { // IOException을 처리하기 위해 throws 추가
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위해 BufferedReader 객체 생성
        long n = Long.parseLong(br.readLine()); // 입력된 값을 long 타입으로 변환
        long result = n; // 결과 값을 n으로 초기화
        for (long p = 2; p <= Math.sqrt(n); p++) { // 2부터 시작하여 n의 제곱근까지 반복
            if (n % p == 0) { // n이 p로 나누어 떨어지면(p가 소인수인지 확인하기)
                result = result - result / p; // 오일러 피 함수 계산(결과값 업데이트)
                while (n % p == 0) { // n이 더 이상 p로 나누어 떨어지지 않을 때까지
                    n /= p; // n을 p로 나눔
                }
            }
        }
        if (n > 1) // 만약 n이 1보다 크다면(아직 소인수 구성이 남아 있을 때)
            result = result - result / n; // 남은 소수로 오일러 피 함수 계산
        System.out.println(result); // 최종 결과 출력
    }
}
