package edu.xidian.vo;

import edu.xidian.model.Order;
import edu.xidian.model.User;

public class UserQueryVO {
    private User user;
    private Order order;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
