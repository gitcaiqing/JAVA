package cq.java8.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

public class TestStream {
	
	@Test
	public void test() {
		List<Plan> plans = new ArrayList<Plan>();
		plans.add(new Plan(1, "1a1", 0, new BigDecimal(11), 14L, new Date()));
		plans.add(new Plan(2, "1b1", 0, new BigDecimal(13), 17L, new Date()));
		plans.add(new Plan(3, "1c1", 1, new BigDecimal(19), 15L, new Date()));
		plans.add(new Plan(4, "1d1", 1, new BigDecimal(15), 13L, new Date()));
		plans.add(new Plan(5, "1e1", 2, new BigDecimal(14), 12L, new Date()));
		
		//�ѱ��planNoת����д �����б�
		List<String> plans2 = plans.stream().map(p -> p.getPlanNo().toUpperCase()).collect(Collectors.toList());
		plans2.forEach(p -> System.out.println("�ѱ��planNoת����д:"+p));
		
		//�۸��ɸߵ�������
		List<Plan> plans3 = plans.stream().sorted( (a, b) -> b.getPrice().compareTo(a.getPrice()) ).collect(Collectors.toList());
		plans3.forEach(p -> System.out.println("�۸��ɸߵ�������:"+p));
		
		//����߼�/��ͼ�/�ܼ�,   total����ƽ��,�ܺ�
		BigDecimal maxPrice = plans.stream().max( (a, b) -> a.getPrice().compareTo(b.getPrice()) ).get().getPrice();
		System.out.println("��߼�:"+maxPrice);
		
		BigDecimal minPrice = plans.stream().min( (a, b) -> a.getPrice().compareTo(b.getPrice()) ).get().getPrice();
		System.out.println("��ͼۣ�"+minPrice);
		
		//total�ܺ�
		Long total = plans.stream().mapToLong( Plan::getTotal).sum();
		System.out.println("total�ܺ�:"+total);
		
		//totalƽ��
		Double avgTotal = plans.stream().mapToDouble( Plan::getTotal).average().getAsDouble();
		System.out.println("totalƽ��:"+avgTotal);
		
		//ת����Map�ṹ <��� ,  �۸�>
		Map<String, Object> map = plans.stream().collect(Collectors.toMap(p->p.getPlanNo(), p->p.getPrice()));
		System.out.println("ת����Map�ṹ <���,�۸�>:"+map);
		
		//list ת ����
		Plan[] planArr = plans.stream().toArray(Plan[]::new);
		System.out.println("ת����");
		Arrays.asList(planArr).stream().forEach(System.out::println);
		
		//��״̬���������ܺ�
		Map<Integer, Long> stateTotalSumMap = plans.stream().collect(Collectors.groupingBy(p->p.getState(), Collectors.summingLong(Plan::getTotal)));
		System.out.println("��״̬���������ܺ�:"+stateTotalSumMap);
		
		//��״̬��������ƽ����
		Map<Integer, Double> stateTotalAvgMap = plans.stream().collect(Collectors.groupingBy(p->p.getState(), Collectors.averagingDouble(Plan::getTotal)));
		System.out.println("��״̬��������ƽ����:"+stateTotalAvgMap);
		
		//LongSummaryStatistics��������Ԫ�صĸ���ժҪ����,�� count, min, max, sum, and average.
		Map<Integer, LongSummaryStatistics> longSummaryStatisticsMap = plans.stream().collect(Collectors.groupingBy(p->p.getState(), Collectors.summarizingLong(Plan::getTotal)));
		System.out.println("LongSummaryStatistics��������Ԫ�صĸ���ժҪ����:\r\n"+longSummaryStatisticsMap);
		
		List<Integer> collect = Arrays.asList(1,2,3,3,5,5,7);
		//ȥ��
		List<Integer> collect1 = collect.stream().distinct().collect(Collectors.toList());
		System.out.println("ȥ��:"+collect1);
		
		//���ظ����ݸ���
		long count = collect.stream().distinct().count();
		System.out.println("���ظ����ݸ���:"+count);
		
		//����ǰ��3������
		List<Integer> collect2 = collect.stream().skip(3).collect(Collectors.toList());
		System.out.println("����ǰ��3������:"+collect2);
		
		
	}
	
}
