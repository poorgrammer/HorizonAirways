package com.px1.horizonairways.da;

import com.px1.horizonairways.entity.AircraftLayout;

public interface FlightAircraftDA {
	AircraftLayout getLayoutByFlightNo(String flightNo);
}
