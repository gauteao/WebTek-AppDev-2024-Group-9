package no.ntnu.stayfinder;

import no.ntnu.stayfinder.model.Hotel;
import no.ntnu.stayfinder.model.Order;
import no.ntnu.stayfinder.repository.HotelRepository;
import no.ntnu.stayfinder.repository.OrderRepository;
import no.ntnu.stayfinder.service.HotelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class HotelServiceTest {

    private HotelService hotelService;
    private HotelRepository hotelRepository;
    private OrderRepository orderRepository;

    @BeforeEach
    public void setUp() {
        hotelRepository = Mockito.mock(HotelRepository.class);
        orderRepository = Mockito.mock(OrderRepository.class);
        hotelService = new HotelService(hotelRepository, orderRepository);
    }

    @Test
    public void testFindAvailableHotels() {
        Hotel hotel1 = new Hotel();
        hotel1.setId(1L);
        Hotel hotel2 = new Hotel();
        hotel2.setId(2L);

        when(hotelRepository.findAll()).thenReturn(Arrays.asList(hotel1, hotel2));
        when(orderRepository.findByHotelIdAndCheckInLessThanEqualAndCheckOutGreaterThanEqual(any(Long.class), any(LocalDate.class), any(LocalDate.class))).thenReturn(Arrays.asList());

        LocalDate checkIn = LocalDate.now();
        LocalDate checkOut = checkIn.plusDays(2);

        List<Hotel> availableHotels = hotelService.findAvailableHotels(checkIn, checkOut);

        assertEquals(2, availableHotels.size());
    }

    @Test
    public void testFindUnavailableHotels() {
        Hotel hotel1 = new Hotel();
        hotel1.setId(1L);
        Hotel hotel2 = new Hotel();
        hotel2.setId(2L);

        Order order = new Order();
        order.setHotelId(1);

        when(hotelRepository.findAll()).thenReturn(Arrays.asList(hotel1, hotel2));
        when(orderRepository.findByHotelIdAndCheckInLessThanEqualAndCheckOutGreaterThanEqual(any(Long.class), any(LocalDate.class), any(LocalDate.class)))
                .thenAnswer(invocation -> {
                    Long hotelId = invocation.getArgument(0);
                    return hotelId.equals(1L) ? Arrays.asList(order) : Arrays.asList();
                });

        LocalDate checkIn = LocalDate.now();
        LocalDate checkOut = checkIn.plusDays(2);

        List<Hotel> availableHotels = hotelService.findAvailableHotels(checkIn, checkOut);

        assertEquals(1, availableHotels.size());
        assertEquals(2L, availableHotels.get(0).getId());
    }
}