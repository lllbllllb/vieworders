package com.test4javadev.pashkouski.bean;

import com.test4javadev.pashkouski.model.Order;
import com.test4javadev.pashkouski.service.OrderService;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean(name = "updateOrderBean")
public class UpdateOrderBean implements Serializable {

    private static final long serialVersionUID = 3420770114130096744L;

    @Inject
    private OrderService orderService;

    private String name = "customer name";

    private String address = "customer address";

    private String amount = "enter the number";

    private Date date;

    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();

        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }

    public String apply() {
        int totalAmount = Integer.parseInt(amount);
        Order order = new Order(name, address, totalAmount, date);

        orderService.save(order);

        return "orders.xhtml?faces-redirect=true";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
