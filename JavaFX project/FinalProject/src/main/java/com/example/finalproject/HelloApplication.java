package com.example.finalproject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class HelloApplication extends Application {
    public  Connection con = null;
    public  PreparedStatement stmt = null;
    public  ResultSet rs = null;
    public Scene StHomeScene;
    public Scene PfHomeScene;
    public Scene AsHomeScene;
    public Scene HomeEmployee;
    public ObservableList<Courses> dataCOST;
    public ObservableList<Student> dataStP;
    public ObservableList<Courses> dataCOAS;
    public ObservableList<Stdata> datastudents;
    public TableView tcoursesST;
    public TableView tcoursesP;
    public TableView tcoas;
    public TableView tstudents;

    public static Alert Alogin,AaddCoSt,AremoveCoSt,AremoveCoP,AaddCoAs ,AaddStEm , AaddStEm2
    ,AremoveStEm ,AremoveStEm2 ,AupdateStEm,AupdateStEm2,AaddCoEm,AaddCoEm2,AremoveCoEm,AremoveCoEm2;


    @Override
    public void start(Stage stage) throws IOException {

        //Adjust Screen
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX(primaryScreenBounds.getMinX());
        stage.setY(primaryScreenBounds.getMinY());
        stage.setWidth(primaryScreenBounds.getWidth());
        stage.setHeight(primaryScreenBounds.getHeight());
        //Sign in
        Label l = new Label("Sign in");
        l.getStyleClass().add("lab1");
        GridPane g = new GridPane();
        g.add(l, 0, 0);
        g.setAlignment(Pos.TOP_CENTER);
        g.setHgap(10);
        g.setVgap(30);
        g.setPadding(new Insets(20, 20, 20, 50));

        Label l1 = new Label("ID :");
        l1.getStyleClass().add("lab2");
        TextField SignInId = new TextField();
        SignInId.setPromptText("input your id");
        Label l2 = new Label("Password :");
        l2.getStyleClass().add("lab2");
        PasswordField SignInPas = new PasswordField();
        SignInPas.setPromptText("input your password");

        Button loginbtn = new Button("Login");
        Button signupbtn = new Button("Sign up");

        GridPane g1 = new GridPane();
        //g1.add(l,1,0);
        g1.add(l1, 0, 1);
        g1.add(SignInId, 1, 1);
        g1.add(l2, 0, 2);
        g1.add(SignInPas, 1, 2);
        g1.add(loginbtn, 0, 4);
        g1.add(signupbtn, 1, 4);
        //g1.add(b3,0,12);

        g1.setAlignment(Pos.CENTER);
        g1.setHgap(10);
        g1.setVgap(10);

        VBox g11 = new VBox(g, g1);
        g11.setSpacing(200);
        int ScreenWidth = 1000;
        int ScreenHeight = 1000;


        Scene SignInScene = new Scene(g11, ScreenWidth, ScreenHeight);
        SignInScene.getStylesheets().add((new File("C:\\Users\\Legion\\IdeaProjects\\oopsec6\\FinalProject\\src\\main\\java\\com\\example\\finalproject\\style.css")).toURI().toString());
        stage.setTitle("Sign in");
        stage.setScene(SignInScene);
        stage.show();
        //.............................................................................................................................
        //Sign Up
        Label ll = new Label("Sign up");
        ll.getStyleClass().add("lab1");

        GridPane gg = new GridPane();
        gg.add(ll, 0, 0);
        gg.setAlignment(Pos.TOP_CENTER);
        gg.setHgap(10);
        gg.setVgap(30);
        gg.setPadding(new Insets(20, 20, 20, 50));

        Label ll1 = new Label("ID :");
        ll1.getStyleClass().add("lab2");
        TextField SignUpId = new TextField();
        SignUpId.setPromptText("input your id");
        Label ll2 = new Label("Password :");
        ll2.getStyleClass().add("lab2");
        PasswordField SignUpPas = new PasswordField();
        SignUpPas.setPromptText("input your password");

        CheckBox cb = new CheckBox();
        Label ll3 = new Label("You Must Remmeber your Password");
        ll3.getStyleClass().add("lab2");

        Button bb1 = new Button("Back");
        Button SingUpbtn = new Button("Sign in");

        GridPane g2 = new GridPane();

        g2.add(ll1, 0, 1);
        g2.add(SignUpId, 1, 1);
        g2.add(ll2, 0, 2);
        g2.add(SignUpPas, 1, 2);
        g2.add(cb, 0, 3);
        g2.add(ll3, 1, 3);
        g2.add(bb1, 0, 4);
        g2.add(SingUpbtn, 1, 4);

        g2.setAlignment(Pos.CENTER);
        g2.setHgap(10);
        g2.setVgap(10);

        VBox g22 = new VBox(gg, g2);
        g22.setSpacing(200);

        Scene SignUpScene = new Scene(g22, ScreenWidth, ScreenHeight);
        SignUpScene.getStylesheets().add((new File("C:\\Users\\Legion\\IdeaProjects\\oopsec6\\FinalProject\\src\\main\\java\\com\\example\\finalproject\\style.css")).toURI().toString());
        //...........................................................................................................................
        //Home Of Students
        //informotion of student
        Label lst = new Label("Student");
        Button ReloadStudent = new Button("Refresh");
        lst.getStyleClass().add("lab1");
        GridPane gs1 = new GridPane();
        gs1.add(lst, 0, 0);
        gs1.add(ReloadStudent,0,1);
        gs1.setAlignment(Pos.TOP_RIGHT);
        gs1.setHgap(10);
        gs1.setVgap(30);
        gs1.setPadding(new Insets(20, 20, 20, 50));

        Label lstn = new Label("Name :");
        lstn.getStyleClass().add("lab2");
        TextField tstn = new TextField();
        tstn.setEditable(false);

        Label lstid = new Label("Id :");
        lstid.getStyleClass().add("lab2");
        TextField tstid = new TextField();
        tstid.setEditable(false);


        Label lstmj = new Label("Major :");
        lstmj.getStyleClass().add("lab2");
        TextField tstmj = new TextField();
        tstmj.setEditable(false);

        Label lstmn = new Label("Minor :");
        lstmn.getStyleClass().add("lab2");
        TextField tstmn = new TextField();
        tstmn.setEditable(false);

        Label lstcg = new Label("CGPA :");
        lstcg.getStyleClass().add("lab2");
        TextField tstcg = new TextField();
        tstcg.setEditable(false);

        Label lstsl = new Label("Study Level :");
        lstsl.getStyleClass().add("lab2");
        TextField tstsl = new TextField();
        tstsl.setEditable(false);

        Button blogouts=new Button("Log out");

        GridPane gs2 = new GridPane();
        gs2.add(lstn, 0, 1);
        gs2.add(tstn, 1, 1);
        gs2.add(lstid, 2, 1);
        gs2.add(tstid, 3, 1);
        gs2.add(lstmj, 0, 2);
        gs2.add(tstmj, 1, 2);
        gs2.add(lstmn, 2, 2);
        gs2.add(tstmn, 3, 2);
        gs2.add(lstcg, 0, 3);
        gs2.add(tstcg, 1, 3);
        gs2.add(lstsl, 2, 3);
        gs2.add(tstsl, 3, 3);
        gs2.add(blogouts,0,35);

        gs2.setAlignment(Pos.CENTER);
        gs2.setHgap(10);
        gs2.setVgap(10);
        gs2.setPadding(new Insets(40, 40, 20, 50));

        VBox gs = new VBox(gs1, gs2);
        //............................................................................................................................
        //update by student
        Label lstaddc = new Label("Add Course");
        lstaddc.getStyleClass().add("lab1");
        TextField tstaddc = new TextField();
        Button bstadd = new Button("Add");

        Label lstremovec = new Label("Remove Course");
        lstremovec.getStyleClass().add("lab1");
        TextField tstremovec = new TextField();
        Button bstremove = new Button("Remove");


        GridPane gst = new GridPane();
        gst.add(lstaddc, 0, 0, 2, 1);
        gst.add(tstaddc, 0, 1);
        gst.add(bstadd, 1, 2);
        gst.add(lstremovec, 0, 3,3,1);
        gst.add(tstremovec, 0, 4);
        gst.add(bstremove, 1, 5);

        gst.setAlignment(Pos.CENTER);
        gst.setHgap(10);
        gst.setVgap(10);
        gst.setPadding(new Insets(40, 40, 20, 50));
        //...............................................................................................
        //table view
        tcoursesST = new TableView();
        tcoursesST.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tcoursesST.setPlaceholder(new Label("No rows to display"));

        TableColumn cn1 = new TableColumn("Code");
        cn1.setCellValueFactory(new PropertyValueFactory<>("Code"));

        TableColumn cn2 = new TableColumn("CreditHours");
        cn2.setCellValueFactory(new PropertyValueFactory<>("CreditHours"));

        TableColumn cn3 = new TableColumn("Name");
        cn3.setCellValueFactory(new PropertyValueFactory<>("Name"));

        tcoursesST.getColumns().addAll(cn1, cn2, cn3);

        VBox vs = new VBox(tcoursesST);
        //v.setPadding(new Insets(20));
        vs.setAlignment(Pos.CENTER);

        //Set Table View With Update informtion by student

        HBox table1 = new HBox(gst, vs);
        //Set All Page OF Student

        FlowPane fs = new FlowPane(gs, table1);
        fs.setAlignment(Pos.CENTER);
       // f.setHgap(5);
        fs.setVgap(10);


        StHomeScene = new Scene(fs, ScreenWidth, ScreenHeight);
        StHomeScene.getStylesheets().add((new File("C:\\Users\\Legion\\IdeaProjects\\oopsec6\\FinalProject\\src\\main\\java\\com\\example\\finalproject\\style.css")).toURI().toString());
        //.......................................................................................................................
        //Home Of prof
        //informotion of prof

        Label lp = new Label("Professor");
        Button ReloadProfessor = new Button("Refresh");
        lp.getStyleClass().add("lab1");
        GridPane gp1 = new GridPane();
        gp1.add(lp, 0, 0);
        gp1.add(ReloadProfessor,0,1);
        gp1.setAlignment(Pos.TOP_RIGHT);
        gp1.setHgap(10);
        gp1.setVgap(30);
        gp1.setPadding(new Insets(20, 20, 20, 50));
        // ......................................................................................

        Label lpn = new Label("Name :");
        lpn.getStyleClass().add("lab2");
        TextField tpn = new TextField();
        tpn.setEditable(false);

        Label lpid = new Label("Id :");
        lpid.getStyleClass().add("lab2");
        TextField tpid = new TextField();
        tpid.setEditable(false);


        Label lpmj = new Label("Major :");
        lpmj.getStyleClass().add("lab2");
        TextField tpmj = new TextField();
        tpmj.setEditable(false);

        Label lpof = new Label("Office :");
        lpof.getStyleClass().add("lab2");
        TextField tpof = new TextField();
        tpof.setEditable(false);

        Label lpc = new Label("Course :");
        lpc.getStyleClass().add("lab2");
        TextField tpc = new TextField();
        tpc.setEditable(false);

        Label lpl = new Label("Course :");
        lpl.getStyleClass().add("lab2");
        TextField tpl = new TextField();
        tpl.setEditable(false);

        Button blogoutp=new Button("Log out");

        GridPane gp2 = new GridPane();
        gp2.add(lpn, 0, 1);
        gp2.add(tpn, 1, 1);
        gp2.add(lpid, 2, 1);
        gp2.add(tpid, 3, 1);
        gp2.add(lpmj, 0, 2);
        gp2.add(tpmj, 1, 2);
        gp2.add(lpof, 2, 2);
        gp2.add(tpof, 3, 2);
        gp2.add(lpc,0,3);
        gp2.add(tpc,1,3);
        gp2.add(lpl,2,3);
        gp2.add(tpl,3,3);
        gp2.add(blogoutp,0,35);

        gp2.setAlignment(Pos.CENTER);
        gp2.setHgap(10);
        gp2.setVgap(10);
        gp2.setPadding(new Insets(40, 40, 20, 50));

        VBox gp = new VBox(gp1, gp2);
        //....................................................................................................................
        //update by prof
        Label lds = new Label("Delete Student");
        lds.getStyleClass().add("lab1");

        Label lid=new Label("Id");
        lid.getStyleClass().add("lab2");
        TextField tpd = new TextField();
        Button bpdelete = new Button("Delete");

        GridPane gpr = new GridPane();
        gpr.add(lds, 0, 0, 2, 1);
        gpr.add(lid,0,1);
        gpr.add(tpd, 1, 1);
        gpr.add(bpdelete, 1, 2);

        gpr.setAlignment(Pos.CENTER);
        gpr.setHgap(5);
        gpr.setVgap(10);
        gpr.setPadding(new Insets(40, 40, 20, 50));

        //.....................................................................................................................
        //table view
        tcoursesP = new TableView();
        tcoursesP.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tcoursesP.setPlaceholder(new Label("No rows to display"));

        TableColumn cp1 = new TableColumn("Name");
        cp1.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));

        TableColumn cp2 = new TableColumn("Id");
        cp2.setCellValueFactory(new PropertyValueFactory<Student,String>("id"));

        TableColumn cp3 = new TableColumn("StudyLevel");
        cp3.setCellValueFactory(new PropertyValueFactory<Student,Integer>("sl"));
        tcoursesP.getColumns().addAll(cp1, cp2, cp3);
        VBox vp = new VBox(tcoursesP);
        //v.setPadding(new Insets(20));
        vp.setAlignment(Pos.CENTER);

        //.....................................................................................................................

        //Set Table View With Update informtion by student

        HBox table2 = new HBox(gpr, vp);
        //Set All Page OF Student

        FlowPane fp = new FlowPane(gp, table2);
        fp.setAlignment(Pos.CENTER);
        // f.setHgap(5);
        fp.setVgap(10);

        PfHomeScene = new Scene(fp, 1000, 1000);
        PfHomeScene.getStylesheets().add((new File("C:\\Users\\Legion\\IdeaProjects\\oopsec6\\FinalProject\\src\\main\\java\\com\\example\\finalproject\\style.css")).toURI().toString());
        /*stage.setScene(PfHomeScene);
        stage.setTitle("Home of Prof");
        stage.fullScreenProperty();
        stage.show();*/

        //.....................................................................................................................
        //Home Of ass
        //informotion of ass
        Label la=new Label("Assistant");
        la.getStyleClass().add("lab1");
        Button ReloadAssistant = new Button("Refresh");
        GridPane ga1 = new GridPane();
        ga1.add(la, 0, 0);
        ga1.add(ReloadAssistant, 0, 1);
        ga1.setAlignment(Pos.TOP_RIGHT);
        ga1.setHgap(10);
        ga1.setVgap(30);
        ga1.setPadding(new Insets(20, 20, 20, 50));
        //.................................................................................................
        Label lan = new Label("Name :");
        lan.getStyleClass().add("lab2");
        TextField tan = new TextField();
        tan.setEditable(false);

        Label laid = new Label("Id :");
        laid.getStyleClass().add("lab2");
        TextField taid = new TextField();
        taid.setEditable(false);


        Label lamj = new Label("Major :");
        lamj.getStyleClass().add("lab2");
        TextField tamj = new TextField();
        tamj.setEditable(false);

        Label lar = new Label("Room :");
        lar.getStyleClass().add("lab2");
        TextField tar = new TextField();
        tar.setEditable(false);

        Button blogouta =new Button("Log out");

        GridPane ga2 = new GridPane();
        ga2.add(lan, 0, 1);
        ga2.add(tan, 1, 1);
        ga2.add(laid, 2, 1);
        ga2.add(taid, 3, 1);
        ga2.add(lamj, 0, 2);
        ga2.add(tamj, 1, 2);
        ga2.add(lar, 2, 2);
        ga2.add(tar, 3, 2);
        ga2.add(blogouta,0,35);

        ga2.setAlignment(Pos.CENTER);
        ga2.setHgap(10);
        ga2.setVgap(10);
        ga2.setPadding(new Insets(40, 40, 20, 50));

        VBox ga = new VBox(ga1, ga2);
        //................................................................................................................
        //update by ass
        Label laaddc = new Label("Add Course");
        laaddc.getStyleClass().add("lab1");
        TextField taaddc = new TextField();
        Button baadd = new Button("Add");

        GridPane gas = new GridPane();
        gas.add(laaddc, 0, 0, 2, 1);
        gas.add(taaddc, 0, 1);
        gas.add(baadd, 1, 2);

        gas.setAlignment(Pos.CENTER);
        gas.setHgap(10);
        gas.setVgap(10);
        gas.setPadding(new Insets(40, 40, 20, 50));
        //................................................................................................
        //table view
        tcoas = new TableView();
        tcoas.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tcoas.setPlaceholder(new Label("No rows to display"));

        TableColumn<Courses, String> col1 = new TableColumn<>("Code");
        col1.setCellValueFactory(new PropertyValueFactory<>("Code"));

        TableColumn<Courses, Integer> col2 = new TableColumn<>("CreditHours");
        col2.setCellValueFactory(new PropertyValueFactory<>("CreditHours"));

        TableColumn<Courses, String> col3 = new TableColumn<>("Name");
        col3.setCellValueFactory(new PropertyValueFactory<>("Name"));

        tcoas.getColumns().addAll(col1, col2, col3);

        VBox va = new VBox(tcoas);
        va.setAlignment(Pos.CENTER);
        //.............................................................................................................
        HBox table3 = new HBox(gas, va);
        //Set All Page OF Student

        FlowPane fa = new FlowPane(ga, table3);
        fa.setAlignment(Pos.CENTER);
        // f.setHgap(5);
        fa.setVgap(10);
        AsHomeScene = new Scene(fa,1000, 1000);
        AsHomeScene.getStylesheets().add((new File("C:\\Users\\Legion\\IdeaProjects\\oopsec6\\FinalProject\\src\\main\\java\\com\\example\\finalproject\\style.css")).toURI().toString());
        /*stage.setScene(AsHomeScene);
        stage.setTitle("Home Assistant");
        stage.show();*/
        //.....................................................................................................................

        Label le1=new Label("Employee");
        le1.getStyleClass().add("labl");
        Button ReloadEmployee = new Button("Refresh");
        GridPane he = new GridPane();
        he.setAlignment(Pos.TOP_RIGHT);
        he.setVgap(30);
        he.setHgap(10);
        he.setPadding(new Insets(20,20,20,50));

        GridPane Home=new GridPane();
        Home.add(le1, 0, 0,2,1);
        Home.add(ReloadEmployee,0,1);
        Home.setAlignment(Pos.CENTER);
        Home.setVgap(10);
        Home.setHgap(10);

        Label ln=new Label("Name:");
        Label li=new Label("ID :");
        Label lpo=new Label("Possition :");
        Label lw=new Label("Working Hours :");

        TextField tn=new TextField();
        tn.setEditable(false);
        TextField ti=new TextField();
        ti.setEditable(false);
        TextField tp=new TextField();
        tp.setEditable(false);
        TextField tw=new TextField();
        tw.setEditable(false);

        GridPane name=new GridPane();
        name.add(ln, 0, 0);
        name.add(tn, 1, 0);
        name.add(li, 2, 0);
        name.add(ti, 3, 0);
        name.add(lpo, 0, 1);
        name.add(tp, 1, 1);
        name.add(lw, 2, 1);
        name.add(tw, 3, 1);
        name.setAlignment(Pos.CENTER);
        name.setHgap(10);
        name.setVgap(10);
        name.setPadding(new Insets(40,40,20,50));

        Label add=new Label("Add Student");
        add.getStyleClass().add("lbl");
        Label lN=new Label("Name :");
        Label lI=new Label("ID :");
        Label lE=new Label("Email :");
        Label lA=new Label("Age :");
        Label lNa=new Label("National ID :");
        Label lC=new Label("CgPA :");
        Label lMa=new Label("Major Dep :");
        Label lMi=new Label("Minor Dep :");
        Label lS=new Label("Study Level :");

        TextField tN=new TextField();
        TextField tI=new TextField();
        TextField tE=new TextField();
        TextField tA=new TextField();
        TextField tNa=new TextField();
        TextField tC=new TextField();
        TextField tMa=new TextField();
        TextField tMi=new TextField();
        TextField tS=new TextField();

        Button Add=new Button("Add");
        Button blogoute =new Button("Log out");

        GridPane a=new GridPane();

        a.add(add, 0, 0,2,1);
        a.add(lN, 0, 1);
        a.add(tN, 1, 1);
        a.add(lI, 0, 2);
        a.add(tI, 1, 2);
        a.add(lE, 0, 3);
        a.add(tE, 1, 3);
        a.add(lA, 0, 4);
        a.add(tA, 1, 4);
        a.add(lNa, 0, 5);
        a.add(tNa, 1, 5);
        a.add(lC, 0, 6);
        a.add(tC, 1, 6);
        a.add(lMa, 0, 7);
        a.add(tMa, 1, 7);
        a.add(lMi, 0, 8);
        a.add(tMi, 1, 8);
        a.add(lS, 0, 9);
        a.add(tS, 1, 9);
        a.add(Add, 0, 10);
        a.add(blogoute, 0, 15);
        a.setAlignment(Pos.CENTER_LEFT);
        a.setVgap(10);
        a.setHgap(10);
        a.setPadding(new Insets(40,40,20,50));

        Label delete=new Label("Delete Student");
        delete.getStyleClass().add("lbl");
        Label leid=new Label("ID :");
        TextField tid=new TextField();
        Button Delete=new Button("Delete");

        GridPane b=new GridPane();
        b.add(delete, 0, 0,2,1);
        b.add(leid, 0, 1);
        b.add(tid, 1, 1);
        b.add(Delete, 0, 2);
        b.setAlignment(Pos.CENTER);
        b.setVgap(10);
        b.setHgap(10);
        b.setPadding(new Insets(40,40,20,50));

        Label update=new Label("Update Student Data");
        update.getStyleClass().add("lbl");
        Label lii=new Label("ID :");
        Label lcc=new Label("CGPA :");
        Label lma=new Label("Major :");
        Label lmi=new Label("Minor :");
        Label lss=new Label("Study Lavel :");

        TextField tii=new TextField();
        TextField tcc=new TextField();
        TextField tma=new TextField();
        TextField tmi=new TextField();
        TextField tss=new TextField();

        Button Update=new Button("Update");


        GridPane c=new GridPane();
        c.add(update, 0, 0,2,1);
        c.add(lii, 0, 1);
        c.add(tii, 1, 1);
        c.add(lcc, 0, 2);
        c.add(tcc, 1, 2);
        c.add(lma, 0, 3);
        c.add(tma, 1, 3);
        c.add(lmi, 0, 4);
        c.add(tmi, 1, 4);
        c.add(lss, 0, 5);
        c.add(tss, 1, 5);
        c.add(Update, 0, 6);
        c.setAlignment(Pos.CENTER);
        c.setVgap(10);
        c.setHgap(10);
        c.setPadding(new Insets(40,40,20,50));

        Label addstudeent=new Label("Add Student Course");
        addstudeent.getStyleClass().add("lbl");
        Label lest=new Label("Student Id :");
        Label lco=new Label("Course Code :");

        TextField tst=new TextField();
        TextField tco=new TextField();

        Button Addd=new Button("Add");

        GridPane d=new GridPane();
        d.add(addstudeent, 0, 0,2,1);
        d.add(lest, 0, 1);
        d.add(tst, 1, 1);
        d.add(lco, 0, 2);
        d.add(tco, 1, 2);
        d.add(Addd, 0, 3);
        d.setAlignment(Pos.CENTER_RIGHT);
        d.setVgap(10);
        d.setHgap(10);
        d.setPadding(new Insets(40,40,20,50));



        Label removestudeent=new Label("Remove Student Course");
        removestudeent.getStyleClass().add("lbl");
        Label lsst=new Label("Student Id :");
        Label lcco=new Label("Course Code :");

        TextField tsst=new TextField();
        TextField tcco=new TextField();

        Button Adddd=new Button("Remove");
        Button displaystudents=new Button("All Students");

        GridPane e=new GridPane();
        e.add(removestudeent, 0, 0,2,1);
        e.add(lsst, 0, 1);
        e.add(tsst, 1, 1);
        e.add(lcco, 0, 2);
        e.add(tcco, 1, 2);
        e.add(Adddd, 0, 3);
        e.add(displaystudents, 0, 6);
        e.setAlignment(Pos.CENTER_RIGHT);
        e.setVgap(10);
        e.setHgap(10);
        e.setPadding(new Insets(40,40,20,50));

        VBox v1=new VBox(b,c);
        VBox v2=new VBox(d,e);
        VBox v3=new VBox(Home,name);
        HBox root=new HBox(a,v1,v2);
        root.setSpacing(150);
        VBox v4=new VBox(v3,root);


        HomeEmployee=new Scene(v4,1000,700);
        HomeEmployee.getStylesheets().add((new File("C:\\Users\\Legion\\IdeaProjects\\oopsec6\\FinalProject\\src\\main\\java\\com\\example\\finalproject\\fx.css")).toURI().toString());
        /*stage.setScene(HomeEmployee);
        stage.setTitle("Home Employee");
        stage.show();*/
        //.....................................................................................................................
        Label displayla = new Label("Display Students");
        displayla.getStyleClass().add("lab1");
        Button displaybtn = new Button("Refresh");
        Button displaybtnback = new Button("Back");

        tstudents = new TableView();
        tstudents.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tstudents.setPlaceholder(new Label("No rows to display"));

        TableColumn cst1 = new TableColumn<>("Name");
        cst1.setCellValueFactory(new PropertyValueFactory<Stdata, String>("Name"));

        TableColumn cst2 = new TableColumn<>("Id");
        cst2.setCellValueFactory(new PropertyValueFactory<Stdata, String>("Id"));

        TableColumn cst3 = new TableColumn<>("Email");
        cst3.setCellValueFactory(new PropertyValueFactory<Stdata, String>("Email"));

        TableColumn cst4 = new TableColumn<>("Age");
        cst4.setCellValueFactory(new PropertyValueFactory<Stdata, Integer>("Age"));

        TableColumn cst5 = new TableColumn<>("NationalId");
        cst5.setCellValueFactory(new PropertyValueFactory<Stdata, String>("NationalId"));

        TableColumn cst6 = new TableColumn<>("Cgpa");
        cst6.setCellValueFactory(new PropertyValueFactory<Stdata, Double>("Cgpa"));

        TableColumn cst7 = new TableColumn<>("MajorDepartment");
        cst7.setCellValueFactory(new PropertyValueFactory<Stdata, String>("MajorDepartment"));

        TableColumn cst8 = new TableColumn<>("MinorDepartment");
        cst8.setCellValueFactory(new PropertyValueFactory<Stdata, String>("MinorDepartment"));

        TableColumn cst9 = new TableColumn<>("StudyLevel");
        cst9.setCellValueFactory(new PropertyValueFactory<Stdata, Integer>("StudyLevel"));

        tstudents.getColumns().addAll(cst1, cst2, cst3,cst4,cst5,cst6,cst7,cst8,cst9);

        VBox h = new VBox(displayla , tstudents , displaybtn ,displaybtnback);
        h.setAlignment(Pos.CENTER);
        h.setPadding(new Insets(40,40,20,50));
        h.setSpacing(20);
        Scene displayall = new Scene(h,1000,700);
        displayall.getStylesheets().add((new File("C:\\Users\\Legion\\IdeaProjects\\oopsec6\\FinalProject\\src\\main\\java\\com\\example\\finalproject\\style.css")).toURI().toString());

        //.....................................................................................................................

        //Alerts
        Alogin = new Alert(Alert.AlertType.ERROR,"Invalid Id or Password Please check your input ");
        Alogin.setTitle("Login");
        Alogin.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        AaddCoSt = new Alert(Alert.AlertType.ERROR,"This course has already been added for this student or \n Adding this course will exceed the maximum allowed credit hours");
        AaddCoSt.setTitle("Add a Course");
        AaddCoSt.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        AremoveCoSt = new Alert(Alert.AlertType.ERROR,"Deleting this course will lower the total credit hours minimum than required.");
        AremoveCoSt.setTitle("Remove a Course");
        AremoveCoSt.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        AremoveCoP = new Alert(Alert.AlertType.ERROR,"Invalid Id");
        AremoveCoP.setTitle("Remove a Course for student");
        AremoveCoP.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        AaddCoAs = new Alert(Alert.AlertType.ERROR,"Maximum of 3 courses can be added");
        AaddCoAs.setTitle("Remove a Course");
        AaddCoAs.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        AaddStEm = new Alert(Alert.AlertType.ERROR,"Student id must begin with 111 & 10 numbers \n Student national id must be 11111111111111 , 22222222222222 of 14 numbers  \n Cgpa must be in range (0->4)" +
                "\nMajor&Minor should be{CS,Mathematics,Physics,Chemistry} , Studty Level{1,2,3,4}");
        AaddStEm.setTitle("Add a student");
        AaddStEm.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        AaddStEm2 = new Alert(Alert.AlertType.INFORMATION,"Student Added");
        AaddStEm2.setTitle("Add a student");
        AaddStEm2.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        AremoveStEm = new Alert(Alert.AlertType.ERROR,"Invalid Id");
        AremoveStEm.setTitle("Remove a student");
        AremoveStEm.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        AremoveStEm2 = new Alert(Alert.AlertType.INFORMATION,"Student Removed");
        AremoveStEm2.setTitle("Remove a student");
        AremoveStEm2.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        AupdateStEm= new Alert(Alert.AlertType.ERROR,"Cgpa must be in range (0->4) \n Major&Minor should be{CS,Mathematics,Physics,Chemistry} , Studty Level{1,2,3,4}");
        AupdateStEm.setTitle("Update a student data");
        AupdateStEm.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        AupdateStEm2= new Alert(Alert.AlertType.INFORMATION,"Data Updated");
        AupdateStEm2.setTitle("Update a student data");
        AupdateStEm2.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        AaddCoEm= new Alert(Alert.AlertType.ERROR,"Your data is invalid");
        AaddCoEm.setTitle("Add a student course");
        AaddCoEm.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        AaddCoEm2= new Alert(Alert.AlertType.INFORMATION,"Course Added");
        AaddCoEm2.setTitle("Add a student course");
        AaddCoEm2.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        AremoveCoEm= new Alert(Alert.AlertType.ERROR,"Your data is invalid");
        AremoveCoEm.setTitle("Remove a student course");
        AremoveCoEm.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        AremoveCoEm2= new Alert(Alert.AlertType.INFORMATION,"Course removed");
        AremoveCoEm2.setTitle("Remove a student course");
        AremoveCoEm2.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        //.....................................................................................................................
        //Logging Buttons
        loginbtn.setOnAction((ActionEvent event) -> {
            try {
                stage.setScene(LogIn(SignInId.getText(),SignInPas.getText()));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            stage.setTitle("Home");
            stage.fullScreenProperty();
            stage.show();
        });

        signupbtn.setOnAction((ActionEvent event) -> {
            stage.setScene(SignUpScene);
            stage.setTitle("Sign up");
            stage.fullScreenProperty();
            stage.show();
        });

        bb1.setOnAction((ActionEvent event) -> {
            stage.setScene(SignInScene);
            stage.setTitle("Sign in");
            stage.fullScreenProperty();
            stage.show();
        });

        SingUpbtn.setOnAction((ActionEvent event) -> {
            try {
                stage.setScene(LogIn(SignUpId.getText(),SignUpPas.getText()));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            SignInId.setText(SignUpId.getText());
            stage.setTitle("Home");
            stage.fullScreenProperty();
            stage.show();
        });

        blogouts.setOnAction((ActionEvent event) -> {
            tstn.clear();
            tstid.clear();
            tstmj.clear();
            tstmn.clear();
            tstcg.clear();
            tstsl.clear();
            dataCOST.clear();
            SignInId.clear();
            SignUpId.clear();
            SignInPas.clear();
            SignUpPas.clear();
            stage.setTitle("Sign in");
            stage.setScene(SignInScene);
            stage.fullScreenProperty();
            stage.show();
        });

        blogoutp.setOnAction((ActionEvent event) -> {
            tpn.clear();
            tpid.clear();
            tpmj.clear();
            tpof.clear();
            tpc.clear();
            tpl.clear();
            tpd.clear();
            dataStP.clear();
            SignInId.clear();
            SignUpId.clear();
            SignInPas.clear();
            SignUpPas.clear();
            stage.setTitle("Sign in");
            stage.setScene(SignInScene);
            stage.fullScreenProperty();
            stage.show();
        });

        blogouta.setOnAction((ActionEvent event) -> {
            tan.clear();
            taid.clear();
            tamj.clear();
            tar.clear();
            taaddc.clear();
            dataCOAS.clear();
            SignInId.clear();
            SignUpId.clear();
            SignInPas.clear();
            SignUpPas.clear();
            stage.setTitle("Sign in");
            stage.setScene(SignInScene);
            stage.fullScreenProperty();
            stage.show();
        });

        blogoute.setOnAction((ActionEvent event) -> {
            SignInId.clear();
            SignUpId.clear();
            SignInPas.clear();
            SignUpPas.clear();
            stage.setTitle("Sign in");
            stage.setScene(SignInScene);
            stage.fullScreenProperty();
            stage.show();
            tn.clear();
            ti.clear();
            tp.clear();
            tw.clear();
            tN.clear();
            tI.clear();
            tE.clear();
            tA.clear();
            tNa.clear();
            tC.clear();
            tMa.clear();
            tMi.clear();
            tS.clear();
            tii.clear();
            tcc.clear();
            tma.clear();
            tmi.clear();
            tss.clear();
            tst.clear();
            tco.clear();
            tsst.clear();
            tcco.clear();
            datastudents.clear();
        });
        displaybtnback.setOnAction((ActionEvent event) -> {
            stage.setTitle("Home");
            stage.setScene(HomeEmployee);
            stage.fullScreenProperty();
            stage.show();
        });
        //.....................................................................................................................
        //Student Home
        ReloadStudent.setOnAction((ActionEvent event) -> {
            if (SignInId.getText() != null)
            {
                try
                {
                    con = DataOperationsPersons.DBConnection();
                    String sql = "SELECT * FROM students WHERE Id=?";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, SignInId.getText());
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                       tstn.setText(rs.getString("Name"));
                       tstid.setText(rs.getString("Id"));
                       tstmj.setText(rs.getString("MajorDepartment"));
                       tstmn.setText(rs.getString("MinorDepartment"));
                       tstcg.setText( rs.getString("Cgpa"));
                       tstsl.setText(rs.getString("StudyLevel"));
                    }
                }
                catch(Exception ex)
                {
                    System.out.println(ex.toString());
                }
               try
                {
                    dataCOST = FXCollections.observableArrayList();
                    con = DataOperationsPersons.DBConnection();
                    String sql = "SELECT courses.Code, courses.CreditHours , courses.Name  FROM studentcourses JOIN courses ON studentcourses.course_id = courses.Code WHERE studentcourses.student_id = ?;";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, SignInId.getText());
                    rs = stmt.executeQuery();
                    while (rs.next()) {
                        dataCOST.add(new Courses(rs.getString("Code") , rs.getInt("CreditHours") , rs.getString("Name")));
                    }
                    rs.close();
                    stmt.close();
                    con.close();
                    tcoursesST.setItems(dataCOST);
                }
                catch (Exception ex)
                {
                    System.out.println(ex.toString());
                }
            }
        });

        bstadd.setOnAction((ActionEvent event) -> {
            Student s = new Student();
            try {
                s.AddCourse(SignInId.getText(),new Courses(tstaddc.getText()));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        bstremove.setOnAction((ActionEvent event) -> {
            Student s = new Student();
            try {
                s.DeleteStudentCourse(SignInId.getText(),new Courses(tstremovec.getText()));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        //.....................................................................................................................
        //Professor Home
        ReloadProfessor.setOnAction((ActionEvent event) -> {
            if (SignInId.getText() != null)
            {
                try
                {
                    con = DataOperationsPersons.DBConnection();
                    String sql = "SELECT * FROM professors WHERE Id=?";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, SignInId.getText());
                    rs = stmt.executeQuery();
                    while (rs.next()) {
                        tpn.setText(rs.getString("Name"));
                        tpid.setText(rs.getString("Id"));
                        tpmj.setText(rs.getString("MajorDepartment"));
                        tpof.setText(rs.getString("Office"));
                        tpc.setText( rs.getString("Course"));
                        tpl.setText(rs.getString("Lecture"));
                    }
                }
                catch(Exception ex)
                {
                    System.out.println(ex.toString());
                }
                try {

                    con = DataOperationsPersons.DBConnection();
                    dataStP = FXCollections.observableArrayList();
                    String sql = "SELECT students.Name , students.Id , students.StudyLevel  FROM studentcourses JOIN students ON studentcourses.student_id = students.Id WHERE studentcourses.course_id = ?;";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, tpc.getText());
                    rs = stmt.executeQuery();
                    while (rs.next()){
                        dataStP.add( new Student(rs.getString("Name"), rs.getString("Id"), rs.getInt("StudyLevel")));
                    }
                    rs.close();
                    stmt.close();
                    con.close();
                    tcoursesP.setItems(dataStP);
                }
                catch (Exception ex){
                    System.out.println(ex.toString());   }
            }
        });

        bpdelete.setOnAction((ActionEvent event) -> {
            Professor p = new Professor();
            try {
                p.DeleteMyStudentCourse(tpd.getText(),new Courses(tpc.getText()));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        //.....................................................................................................................
        //Assistant Home
        ReloadAssistant.setOnAction((ActionEvent event) -> {
            if (SignInId.getText() != null)
            {
                try
                {
                    con = DataOperationsPersons.DBConnection();
                    String sql = "SELECT * FROM teachingassistants WHERE Id=?";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, SignInId.getText());
                    rs = stmt.executeQuery();
                    while (rs.next()) {
                        tan.setText(rs.getString("Name"));
                        taid.setText(rs.getString("Id"));
                        tamj.setText(rs.getString("MajorDepartment"));
                        tar.setText(rs.getString("Room"));
                    }
                }
                catch(Exception ex)
                {
                    System.out.println(ex.toString());
                }
                try {
                    dataCOAS = FXCollections.observableArrayList();
                    con = DataOperationsPersons.DBConnection();
                    String sql = "SELECT courses.Code, courses.CreditHours , courses.Name  FROM assistantscourses JOIN courses ON assistantscourses.course_id = courses.Code WHERE assistantscourses.assistant_id = ?;";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, SignInId.getText());
                    rs = stmt.executeQuery();
                    while (rs.next()) {
                        dataCOAS.add( new Courses(rs.getString("Code") ,rs.getInt("CreditHours") , rs.getString("Name")));
                    }
                    rs.close();
                    stmt.close();
                    con.close();
                    tcoas.setItems(dataCOAS);
                }
                catch (Exception ex){
                    System.out.println(ex.toString());}
        }});

        baadd.setOnAction((ActionEvent event) -> {
            TeachingAssistants t = new TeachingAssistants();
            try {
                t.AddCourse(taid.getText(),new Courses(taaddc.getText()));
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        });
        //.....................................................................................................................
        //Employer Home
        ReloadEmployee.setOnAction((ActionEvent event)->{
            if (SignInId.getText() != null)
            {
                try
                {
                    con = DataOperationsPersons.DBConnection();
                    String sql = "SELECT * FROM employers WHERE Id=?";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, SignInId.getText());
                    rs = stmt.executeQuery();
                    while (rs.next()) {
                        tn.setText(rs.getString("Name"));
                        ti.setText(rs.getString("Id"));
                        tp.setText(rs.getString("Position"));
                        tw.setText(rs.getString("WorkingHours"));
                    }
                }
                catch(Exception ex)
                {
                    System.out.println(ex.toString());
                }
        }});

        Add.setOnAction((ActionEvent event) -> {
            try {
                Student s = new Student(tN.getText(),tI.getText(),tE.getText(),Integer.parseInt(tA.getText()),tNa.getText(),Double.parseDouble(tC.getText()),tMa.getText(),tMi.getText(),Integer.parseInt(tS.getText()));
                AaddStEm2.show();
            } catch (Exception ex) {
                AaddStEm.show();
                System.out.println(ex.toString());
            }
        });

        Delete.setOnAction((ActionEvent event) -> {
            if (tsst.getText().length()!=10 && !tsst.getText().startsWith("111")){AremoveStEm.show();
                throw new RuntimeException();}
            try {
                Student S = new Student();
                S.Delete(tsst.getText());
            }catch (Exception ex){
                System.out.println(ex.toString());
            }
        });

        Update.setOnAction((ActionEvent event) -> {
            Student s = new Student();
            try {
                s.Update(tii.getText(),Double.parseDouble(tcc.getText()),tma.getText(),tmi.getText(),Integer.parseInt(tss.getText()));
                AupdateStEm2.show();
            } catch (Exception ex) {
                AupdateStEm.show();
                System.out.println(ex.toString());
            }
        });

        Addd.setOnAction((ActionEvent event) -> {
            Student s = new Student();
            if (tst.getText().equals("") && tco.getText().equals("")){
                AaddCoEm.show();
            throw new RuntimeException();}
            try {
                s.AddCourse(tst.getText(),new Courses(tco.getText()));
            }catch (Exception ex){
                System.out.println(ex.toString());
            }
        });

        Adddd.setOnAction((ActionEvent event) -> {
            Student s = new Student();
            if (tst.getText().equals("") && tco.getText().equals("")){AremoveCoEm.show();
                throw new RuntimeException();}
            try {
                s.DeleteStudentCourse(tst.getText(),new Courses(tco.getText()));
            }catch (Exception ex){
                System.out.println(ex.toString());
            }
        });

        displaystudents.setOnAction((ActionEvent event) ->{
            stage.setScene(displayall);
            stage.setTitle("All Students");
            stage.fullScreenProperty();
            stage.show();
        });

        displaybtn.setOnAction((ActionEvent event) ->{
            try {

                con = DataOperationsPersons.DBConnection();
                datastudents = FXCollections.observableArrayList();
                String sql = "SELECT * FROM students";
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();
                while (rs.next()){
                    datastudents.add( new Stdata(rs.getString("Name"), rs.getString("Id"),rs.getString("Email"),Integer.parseInt(rs.getString("Age")),
                            rs.getString("NationalId"),Double.parseDouble(rs.getString("Cgpa")),rs.getString("MajorDepartment")
                            ,rs.getString("MinorDepartment"), Integer.parseInt(rs.getString("StudyLevel"))));
                }
                rs.close();
                stmt.close();
                con.close();
                tstudents.setItems(datastudents);
            }
            catch (Exception ex){
                System.out.println(ex.toString());   }
        });
        //.....................................................................................................................


    }
    public Scene LogIn (String Id , String NationalId) throws SQLException {
        try {
            if (Id != null && NationalId != null && Id.length() == 10 && NationalId.length() == 14) {
                con = DataOperationsPersons.DBConnection();
                if (Id.startsWith("111"))
                {
                    String sql = "SELECT Id , NationalId FROM students WHERE Id = ?";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, Id);
                    rs = stmt.executeQuery();
                    if (rs.next() && Id.equals(rs.getString("Id")) && NationalId.equals(rs.getString("NationalId")))
                    {    return StHomeScene;     }
                }
                else if (Id.startsWith("333"))
                {
                    String sql = "SELECT Id , NationalId FROM professors WHERE Id = ?";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, Id);
                    rs = stmt.executeQuery();
                    if (rs.next() && Id.equals(rs.getString("Id")) && NationalId.equals(rs.getString("NationalId")))
                    {    return PfHomeScene;     }
                }
                else if (Id.startsWith("555"))
                {
                    String sql = "SELECT Id , NationalId FROM teachingassistants WHERE Id = ?";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, Id);
                    rs = stmt.executeQuery();
                    if (rs.next() && Id.equals(rs.getString("Id")) && NationalId.equals(rs.getString("NationalId")))
                    {    return AsHomeScene;     }
                }
                else if (Id.startsWith("777"))
                {
                    String sql = "SELECT Id , NationalId FROM employers WHERE Id = ?";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, Id);
                    rs = stmt.executeQuery();
                    if (rs.next() && Id.equals(rs.getString("Id")) && NationalId.equals(rs.getString("NationalId")))
                    {    return HomeEmployee;     }
                }
            }else { Alogin.show();}
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        rs.close();
        stmt.close();
        con.close();
        return null;
        }

    public static void main (String[]args){
            launch();
        }
    }
