package com.malichenko.lesson5.dz;
//сразу сознаюсь что сам решить не смог, это решение нашел В КНИЖКЕ У Лафоре. но решение пытался разобрать, все же хотел бы услышать разбор дз на уроке... своего ума не хватает)
public class Hanoi {

    public static int count = 0;

    public static void main(String[] args) {
        move(3, '1', '2', '3');
    }

    public static void move(int topDisk, char source, char buffer, char destination) {
        System.out.println("Enter (" + topDisk + " disks): source= " + source + ", buffer= " + buffer + ", destination= " + destination);
        if (topDisk == 1) {
            ++count;
            System.out.println("Step " + count + " Base case: move disk " + topDisk + " from " + source + " to " + destination);
        } else {
            move(topDisk - 1, source, destination, buffer); // source-->buffer
            ++count;
            System.out.println("Step " + count + " Move bottom disk " + topDisk + " from " + source + " to " + destination);
            move(topDisk - 1, buffer, source, destination); // buffer-->destination
        }
        System.out.println("Return ("+ topDisk +" disk)");
    }
}
//    действие	вложен.	шаг	описание	s	b	d	disk
//        1 	1   		enter	    1	2	3	3	    n-1     source-->destination
//        2	    2   		enter	    1	3	2	2	    n-1         source-->buffer
//        3	    3   		enter	    1	2	3	1	    n==1            source-->destination
//        4	    3   	1	move base	1		3	1	    n==1            1!source-->destination
//        5	    3   		return				1                       source-->buffer
//        6	    2   	2	move bottom	1		2	2                   2!source-->buffer
//        7	    3   		enter	    3	1	2	1	    n==1            destination-->buffer
//        8	    3   	3	move base	3		2	1	    n==1            3!destination-->buffer
//        9	    3   		return				1                       source-->buffer
//        10	2   		return				2                   source-->destination
//        11	1   	4	move bottom	1		3	3	    n-1     4!source-->destination
//        12	2   		enter	    2	1	3	2	    n-1         buffer-->destination
//        13	3   		enter	    2	3	1	1	    n==1            buffer-->source
//        14	3   	5	move base	2		1	1	    n==1            5!buffer-->source
//        15	3   		return				1                       buffer-->destination
//        16	2   	6	move bottom	2		3	2	    n-1         6!buffer-->destination
//        17	3   		enter	    1	2	3	1	    n==1            source-->destination
//        18	3   	7	move base	1		3	1	    n==1            7!source-->destination
//        19	3   		return				1                       buffer-->destination
//        20	2   		return				2                   source-->destination
//        21	1   		return				3                   end
