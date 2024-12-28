class SinhVien{
    private String MSSV;
    private String HoTen;
    private String Date;
    private String nganh;
    private int dtb;
    public SinhVien(String MSSV, String HoTen, String Date, String nganh, int dtb){
        this.MSSV=MSSV;
        this.HoTen=HoTen;
        this.Date=Date;
        this.nganh=nganh;
        this.dtb=dtb;
    }
    public String getMSSV(){
        return MSSV;
    }
    public String getHoTen(){
        return HoTen;
    }
    public String getDate(){
        return Date;
    }
    public String getNganh(){
        return nganh;
    }
    public int getDtb(){
        return dtb;
    }
    public void nhap(){
        Scanner sc=new Scanner(System.in);
        MSSV=sc.nextLine();
        HoTen=sc.nextLine();
        Date=sc.nextLine();
        nganh=sc.nextLine();
        dtb=sc.nextInt();
    }
    public void xuat(){
        System.out.println("MSSV: "+MSSV);
        System.out.println("Ho ten: "+HoTen);
        System.out.println("Ngay sinh: "+Date);
        System.out.println("Nganh: "+nganh);
        System.out.println("Diem trung binh: "+dtb);
    }
}
class DSSinhVien{
    private int n;
    private SinhVien[] dssv;
    public DSSinhVien(){
        n=0;
        dssv=new SinhVien[0];
    }
    public DSSinhVien(int n, SinhVien[] dssv){
        this.n=n;
        this.dssv=dssv;
    }
    public void nhap(){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        dssv= new SinhVien[n];
        for(int i=0;i<n;i++){
            dssv[i]= new SinhVien();
            dssv[i].nhap();
        }
    }
    public void xuat(){
        for(int i=0;i<n;i++){
            dssv[i].xuat();
        }
    }
    public void them(){
        dssv=Arrays.copyOf(dssv,n+1);
        dssv[n]=new SinhVien();
        dssv[n].nhap();
        n++
    }
    public void timkiem(){
        Scanner sc=new Scanner(System.in);
        String find=sc.nextLine();
        timkiem(find);
    }
    public void timkiem(String HoTen){
        for(int i=0;i<n;i++){
            if(dssv[i].getHoTen().equals(find)){
                dssv[i].xuat();
            }
        }
    }
}
class LopHoc{
    private String MSLop;
    private SinhVien[] dssv;
    public LopHoc(){
        MSLop="";
        dssv=new SinhVien[0];
    }
    public LopHoc(String MSLop, SinhVien[] dssv){
        this.MSLop=MSLop;
        this.dssv=dssv;
    }
    public String getMSLop(){
        return MSLop;
    }
    public SinhVien[] getSinhVien(){
        return dssv;
    }
    
}