package com.designPattens.responsibilityChain;

/**
 * 责任链模式，将任务的处理封装层一个个对象，实现处理之间解耦，一层一层的往下传
 */
public class MainTest {

    public static void main(String[] args) {

        Approver GroupLeader=new GroupApprover("Tom");
        Approver DepartmentLeader=new DepartmentApprover("Jerry");
        Approver VicePresident=new VicePresidentApprover("Kate");
        Approver President=new PresidentApprover("Bush");
        
        GroupLeader.SetSuccessor(VicePresident);
        DepartmentLeader.SetSuccessor(President);
        VicePresident.SetSuccessor(DepartmentLeader);
        President.SetSuccessor(GroupLeader);

        VicePresident.ProcessRequest(new PurchaseRequest(1, 100, 40));
        VicePresident.ProcessRequest(new PurchaseRequest(2, 200, 40));
        VicePresident.ProcessRequest(new PurchaseRequest(3, 300, 40));
        VicePresident.ProcessRequest(new PurchaseRequest(4, 400, 140));
    }
}