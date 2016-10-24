package com.test4javadev.pashkouski.bean;

import com.test4javadev.pashkouski.model.Order;
import com.test4javadev.pashkouski.service.OrderService;
import com.test4javadev.pashkouski.service.SoapService;
import org.primefaces.model.TreeNode;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean(name = "viewBean")
@ViewScoped
public class ViewBean implements Serializable {

    private static final long serialVersionUID = -5030727156792555911L;

    private TreeNode root;

    private TreeNode selectedNode;

    private String entryDate;

    @Inject
    private OrderService orderService;

    @Inject
    private SoapService soapService;

    @ManagedProperty("#{treeService}")
    private ServiceBean viewbean;

    @PostConstruct
    public void init() {
        root =  viewbean.createTree();
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public void setViewbean(ServiceBean viewbean) {
        this.viewbean = viewbean;
    }

    public void displaySelectedSingle() {
        if(selectedNode != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", selectedNode.getData().toString());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void deleteNode() {
//
//        Object object = selectedNode.getData();
//        if (object instanceof Order) {
//            orderService.delete(((Order) object).getId());
//        }

        selectedNode.getChildren().clear();
        selectedNode.getParent().getChildren().remove(selectedNode);
        selectedNode.setParent(null);
        selectedNode = null;


    }

    public String getEntryDate() {
        entryDate = soapService.getDate();
        return entryDate;
    }
}
