import { RestaurantCategory } from './restaurant-category';
import { Item } from './item';

export class Restaurant {
    id: number;
    name: string;
    address: string;
    logo: string;
    category: RestaurantCategory;
    foodItems: Array<Item>;
    drinks: Array<Item>;
    deleted: boolean
}