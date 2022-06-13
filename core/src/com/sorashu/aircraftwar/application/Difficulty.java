package com.sorashu.aircraftwar.application;

public enum Difficulty {
    EASY(5,Integer.MAX_VALUE),
    NORMAL(5,400),
    DIFFICULT(7,500);

    private final int enemyMaxNum;
    private final int bossScoreThereShould;

    Difficulty(int enemyMaxNum,int bossScoreThereShould) {
        this.enemyMaxNum = enemyMaxNum;
        this.bossScoreThereShould = bossScoreThereShould;
    }

    public int getEnemyMaxNum() {
        return this.enemyMaxNum;
    }

    public int getBossScoreThereShould() {
        return this.bossScoreThereShould;
    }
}
