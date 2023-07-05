package com.giuliana.ec2_dam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.giuliana.ec2_dam.databinding.FragmentMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapsFragment : Fragment(), OnMapReadyCallback {
    private var _binding: FragmentMapsBinding? = null
    private val binding get() = _binding!!

    private lateinit var googleMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMapsBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentMap = childFragmentManager.findFragmentById(R.id.fcv_map) as SupportMapFragment
        fragmentMap.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        val megaplazaLocation = LatLng(-11.993455015027168, -77.06104517020441)
        googleMap.addMarker(MarkerOptions().position(megaplazaLocation).title("Megaplaza"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(megaplazaLocation, 16f))
        val terminalLocation = LatLng(-11.98153284070917, -77.05877065662267)
        googleMap.addMarker(MarkerOptions().position(terminalLocation).title("Metropolitano Terminal"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(terminalLocation, 16f))
        val municipalidadLocation = LatLng(-11.996603388572176, -77.05465078412205)
        googleMap.addMarker(MarkerOptions().position(municipalidadLocation).title("Municipalidad Independencia"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(municipalidadLocation, 16f))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}