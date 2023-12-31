package com.kartik.Ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String orderId;
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime orderDate;

    private LocalDateTime deliveryDate;
    @OneToOne
    private Address shippingAddress;

    @Embedded
    private PaymentDetails paymentDetails = new PaymentDetails();

    private Integer totalPrice;

    private Integer totalDiscountedPrice;
    private Integer discount;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private int totalItem;
    private LocalDateTime createdAt;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", user=" + (user != null ? user : "null") +
                ", orderItems=" + orderItems +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", shippingAddress=" + shippingAddress +
                ", paymentDetails=" + paymentDetails +
                ", totalPrice=" + totalPrice +
                ", totalDiscountedPrice=" + totalDiscountedPrice +
                ", discount=" + discount +
                ", orderStatus=" + orderStatus +
                ", totalItem=" + totalItem +
                ", createdAt=" + createdAt +
                '}';
    }
}
