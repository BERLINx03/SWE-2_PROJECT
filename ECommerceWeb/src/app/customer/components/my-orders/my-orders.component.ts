import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';

@Component({
  selector: 'app-my-orders',
  templateUrl: './my-orders.component.html',
  styleUrls: ['./my-orders.component.scss']
})
export class MyOrdersComponent {

  myOrders:any;

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
    this.getMyOrders();
  }

  getMyOrders() {
    this.customerService.getOrderByUserId().subscribe(res => {
        this.myOrders = res;
      
    })
  }

}
