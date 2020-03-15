/**
 * Put
 */
public class Put {

    int put(int[] o) {
        for (int i = 0; i < 9; i++) {
            if (o[i] == 1) {
                System.out.println("Put.put()" + i);
                // Horizontal
                if (i + 1 < 9 && o[i + 1] == 1) {
                    // o[i+2]==0 && i%3==0
                    if (o[i + 2] == 0 && i % 3 == 0) {
                        System.out.println(i + 3);
                        return i + 3;
                    } else if (o[i - 1] == 0 && i % 3 == 1) {
                        System.out.println(i);
                        return i;
                    }
                } else if (i + 2 < 9 && o[i + 2] == 1 && o[i + 1] == 0) {
                    return i + 2;
                }
                // Vertical
                else if (i + 3 < 9 && o[i + 3] == 1) {
                    if (i + 6 < 9 && o[i + 6] == 0) {
                        System.out.println(i + 7);
                        return i + 7;
                    } else if (i - 3 > 0 && o[i - 3] == 0) {
                        System.out.println(i - 2);
                        return i - 2;
                    }
                } else if (i + 6 < 9 && o[i + 6] == 1 && o[i + 3] == 0) {
                    return i + 4;
                }
                // Cross
                else if (o[0] == 1) {
                    System.out.println("0 is 1");
                    if (o[4] == 1 && o[8] == 0) {
                        return 9;
                    } else if (o[8] == 1 && o[4] == 0) {
                        return 5;
                    }
                } else if (o[2] == 1) {
                    System.out.println("2 is 1");
                    if (o[4] == 1 && o[6] == 0) {
                        return 7;
                    } else if (o[6] == 1 && o[4] == 0) {
                        return 5;
                    }
                } else if (o[4] == 1) {
                    System.out.println("4 is 1");
                    if (o[6] == 1 && o[2] == 0) {
                        return 3;
                    } else if (o[8] == 1 && o[0] == 0) {
                        return 1;
                    }
                }

            }
        }
        if (o[0] == 0) {
            return 1;
        } else if (o[2] == 0) {
            return 3;
        } else if (o[6] == 0) {
            return 7;
        } else if (o[8] == 0) {
            return 9;
        } else {
            for (int i = 0; i < 9; i++) {
                if (o[i] == 0) {
                    return i + 1;
                }
            }
        }
        return 0;
    }
}