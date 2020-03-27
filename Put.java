/**
 * Put
 */
public class Put {

    int put(int[] o, char f) {
        int x;
        if (f == 'n') {
            x = 2;
        } else {
            x = 1;
        }
        for (int i = 0; i < 9; i++) {
            // Win
            if (o[i] == x) {
                // Horizontal
                if (i + 1 < 9 && o[i + 1] == x) {
                    if (i + 2 < 9 && o[i + 2] == 0 && i % 3 == 0) {
                        return i + 3;
                    } else if (i - 1 >= 0 && o[i - 1] == 0 && i % 3 == 1) {
                        return i;
                    }
                } else if (i + 2 < 9 && o[i + 2] == x && o[i + 1] == 0 && i % 3 == 0) {
                    return i + 2;
                }
                // Vertical
                else if (i + 3 < 9 && o[i + 3] == x) {
                    if (i + 6 < 9 && o[i + 6] == 0) {
                        return i + 7;
                    } else if (i - 3 >= 0 && o[i - 3] == 0) {
                        return i - 2;
                    }
                } else if (i + 6 < 9 && o[i + 6] == x && o[i + 3] == 0) {
                    return i + 4;
                }
                // Cross
                else if (o[0] == x) {
                    if (o[4] == x && o[8] == 0) {
                        return 9;
                    } else if (o[8] == x && o[4] == 0) {
                        return 5;
                    }
                } else if (o[2] == x) {
                    if (o[4] == x && o[6] == 0) {
                        return 7;
                    } else if (o[6] == x && o[4] == 0) {
                        return 5;
                    }
                } else if (o[4] == x) {
                    if (o[6] == x && o[2] == 0) {
                        return 3;
                    } else if (o[8] == x && o[0] == 0) {
                        return 1;
                    }
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            // Check Win
            if (o[i] == 3 - x) {
                // Horizontal
                if (i + 1 < 9 && o[i + 1] == 3 - x) {
                    if (i + 2 < 9 && o[i + 2] == 0 && i % 3 == 0) {
                        return i + 3;
                    } else if (i - 1 >= 0 && o[i - 1] == 0 && i % 3 == 1) {
                        return i;
                    }
                } else if (i + 2 < 9 && o[i + 2] == 3 - x && o[i + 1] == 0 && i % 3 == 0) {
                    return i + 2;
                }
                // Vertical
                if (i + 3 < 9 && o[i + 3] == 3 - x) {
                    if (i + 6 < 9 && o[i + 6] == 0) {
                        return i + 7;
                    } else if (i - 3 >= 0 && o[i - 3] == 0) {
                        return i - 2;
                    }
                } else if (i + 6 < 9 && o[i + 6] == 3 - x && o[i + 3] == 0) {
                    return i + 4;
                }
                // Cross
                else if (o[0] == 3 - x) {
                    if (o[4] == 3 - x && o[8] == 0) {
                        return 9;
                    } else if (o[8] == 3 - x && o[4] == 0) {
                        return 5;
                    }
                } else if (o[2] == 3 - x) {
                    if (o[4] == 3 - x && o[6] == 0) {
                        return 7;
                    } else if (o[6] == 3 - x && o[4] == 0) {
                        return 5;
                    }
                } else if (o[4] == 3 - x) {
                    if (o[6] == 3 - x && o[2] == 0) {
                        return 3;
                    } else if (o[8] == 3 - x && o[0] == 0) {
                        return 1;
                    }
                }
            }
        }
        if (o[4] == 0) {
            return 5;
        } else if (o[0] == 3 - x && o[8] == 0) {
            return 9;
        } else if (o[2] == 3 - x && o[6] == 0) {
            return 7;
        } else if (o[6] == 3 - x && o[2] == 0) {
            return 3;
        } else if (o[8] == 3 - x && o[0] == 0) {
            return 1;
        } else {
            if (o[0] == 0) {
                return 1;
            } else if (o[2] == 0) {
                return 3;
            } else if (o[6] == 0) {
                return 7;
            } else if (o[8] == 0) {
                return 9;
            }
            for (int i = 0; i < 9; i++) {
                if (o[i] == 0) {
                    return i + 1;
                }
            }
        }
        return 0;
    }
}