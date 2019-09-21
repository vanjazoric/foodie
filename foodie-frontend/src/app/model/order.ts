import { OrderItem } from './orderItem';

export class Order {
    amount: number;
    note: string;
    userPhone: string;
    userAddress:string;
    orderItems: OrderItem[];
}