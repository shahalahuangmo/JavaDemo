package com.example.demo.system.model.value;

/**
 * 民族类别
 */
public enum NationType {
    BuXiang("不详", 0),
    HanZu("汉族", 1),
    ChaoXianZu("朝鲜族", 10),
    ManZu("满族", 11),
    DongZu("侗族", 12),
    YaoZu("瑶族", 13),
    BaiZu("白族", 14),
    TuJiaZu("土家族", 15),
    HaNiZu("哈尼族", 16),
    HaSaKeZu("哈萨克族", 17),
    DaiZu("傣族", 18),
    LiZu("黎族", 19),
    MengGuZu("蒙古族", 2),
    SuSuZu("僳僳族", 20),
    WaZu("佤族", 21),
    SheZu("畲族", 22),
    GaoShanZu("高山族", 23),
    LaHuZu("拉祜族", 24),
    ShuiZu("水族", 25),
    DongXiangZu("东乡族", 26),
    NaXiZu("纳西族", 27),
    JingPoZu("景颇族", 28),
    KeEKeZiZu("柯尔克孜族", 29),
    HuiZu("回族", 3),
    TuZu("土族", 30),
    DaWoEZu("达斡尔族", 31),
    MuLaoZu("仫佬族", 32),
    QiangZu("羌族", 33),
    BuLangZu("布朗族", 34),
    SaLaZu("撒拉族", 35),
    MaoNanZu("毛难族", 36),
    GeLaoZu("仡佬族", 37),
    XiBoZu("锡伯族", 38),
    AChangZu("阿昌族", 39),
    CangZu("藏族", 4),
    PuMiZu("普米族", 40),
    TaJiKeZu("塔吉克族", 41),
    NuZu("怒族", 42),
    WuZiBieKeZu("乌孜别克族", 43),
    ELuoSiZu("俄罗斯族", 44),
    EWenKeZu("鄂温克族", 45),
    BengLongZu("崩龙族", 46),
    BaoAnZu("保安族", 47),
    YuGuZu("裕固族", 48),
    JingZu("京族", 49),
    WeiWuEZu("维吾尔族", 5),
    TaTaEZu("塔塔尔族", 50),
    DuLongZu("独龙族", 51),
    ELunChunZu("鄂伦春族", 52),
    HeZheZu("赫哲族", 53),
    MenBaZu("门巴族", 54),
    LuoBaZu("珞巴族", 55),
    JiNuoZu("基诺族", 56),
    QiTa("其他", 57),
    WaiGuoXueTong("外国血统", 58),
    MiaoZu("苗族", 6),
    YiZu("彝族", 7),
    ZhuangZu("壮族", 8),
    BuYiZu("布依族", 9),
    ChuanQingRen("穿青人", 97),
    MoSuoRen("摩梭人", 98);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private NationType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
