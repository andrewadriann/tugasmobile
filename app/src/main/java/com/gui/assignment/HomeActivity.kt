package com.gui.assignment

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_home.*
import java.io.IOException


class HomeActivity : FragmentActivity() , OnMapReadyCallback, LocationListener,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{

    private var mMap: GoogleMap? = null
    internal lateinit var mLastLocation: Location
    internal var mCurrLocationMarker: Marker? = null
    internal var mGoogleApiClient: GoogleApiClient? = null
    internal lateinit var mLocationRequest: LocationRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        moveToFragment(HomeFragment())
        fragment_container.visibility = View.VISIBLE
        fragment_container.bringToFront()
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.google_map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        titlemain.setText(txthome.text.toString())
        btnMenu.setOnClickListener{
            val intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }
        termbtn.setOnClickListener {
            val intent = Intent(this,TermsConditionActivity::class.java)
            startActivity(intent)
        }

    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient()
                mMap!!.isMyLocationEnabled = true
            }
        } else {
            buildGoogleApiClient()
            mMap!!.isMyLocationEnabled = true
        }

    }
    @Synchronized
    protected fun buildGoogleApiClient() {
        mGoogleApiClient = GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build()
        mGoogleApiClient!!.connect()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun go(view: View) {
        moveToFragment(PengacaraFragment())
        map_layout.visibility = View.GONE

        fragment_container.visibility = View.VISIBLE
        fragment_container.bringToFront()
        btnHome.setImageResource(R.drawable.homeblack)
        txthome.setTextColor(getColor(R.color.purple_200))
        law.setImageResource(R.drawable.lawyellow)
        lawtxt.setTextColor(getColor(R.color.textColor))
        cariimg.setImageResource(R.drawable.search)
        caritxt.setTextColor(getColor(R.color.purple_200))

        primg.setImageResource(R.drawable.profile)
        prname.setTextColor(getColor(R.color.purple_200))
        titlemain.setText(lawtxt.text.toString())
    }
    private fun moveToFragment(fragment: Fragment)
    {
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragment_container,fragment)
        fragmentTrans.commit()


    }
    override fun onConnected(bundle: Bundle?) {

        mLocationRequest = LocationRequest()
        mLocationRequest.interval = 1000
        mLocationRequest.fastestInterval = 1000
        mLocationRequest.priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
        if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.getFusedLocationProviderClient(this)
        }
    }
    override fun onConnectionSuspended(i: Int) {

    }

    override fun onLocationChanged(location: Location) {

        mLastLocation = location
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker!!.remove()
        }
        //Place current location marker
        val latLng = LatLng(location.latitude, location.longitude)
        val markerOptions = MarkerOptions()
        markerOptions.position(latLng)
        markerOptions.title("Current Position")
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        mCurrLocationMarker = mMap!!.addMarker(markerOptions)

        //move map camera
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        mMap!!.animateCamera(CameraUpdateFactory.zoomTo(11f))

        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.getFusedLocationProviderClient(this)
        }

    }

    override fun onConnectionFailed(connectionResult: ConnectionResult) {

    }


    @RequiresApi(Build.VERSION_CODES.M)
    fun one(view: View) {
        fragment_container.visibility = View.VISIBLE
        map_layout.visibility = View.GONE

        fragment_container.bringToFront()
        moveToFragment(HomeFragment())
        btnHome.setImageResource(R.drawable.homeicon)
        txthome.setTextColor(getColor(R.color.textColor))
        law.setImageResource(R.drawable.law)
        lawtxt.setTextColor(getColor(R.color.purple_200))
        cariimg.setImageResource(R.drawable.search)
        caritxt.setTextColor(getColor(R.color.purple_200))

        primg.setImageResource(R.drawable.profile)
        prname.setTextColor(getColor(R.color.purple_200))
        titlemain.setText(txthome.text.toString())
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun fourth(view: View) {
        fragment_container.visibility = View.VISIBLE
        map_layout.visibility = View.GONE

        fragment_container.bringToFront()
        moveToFragment(ProfileFragment())
        btnHome.setImageResource(R.drawable.homeblack)
        txthome.setTextColor(getColor(R.color.purple_200))
        law.setImageResource(R.drawable.law)
        lawtxt.setTextColor(getColor(R.color.purple_200))
        cariimg.setImageResource(R.drawable.search)
        caritxt.setTextColor(getColor(R.color.purple_200))

        primg.setImageResource(R.drawable.personyellow)
        prname.setTextColor(getColor(R.color.textColor))
        titlemain.setText(prname.text.toString())
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun map(view: View) {
        fragment_container.visibility = View.GONE
        map_layout.visibility = View.VISIBLE
        btnHome.setImageResource(R.drawable.homeblack)
        txthome.setTextColor(getColor(R.color.purple_200))
        law.setImageResource(R.drawable.law)
        lawtxt.setTextColor(getColor(R.color.purple_200))
        cariimg.setImageResource(R.drawable.searchyellow)
        caritxt.setTextColor(getColor(R.color.textColor))

        primg.setImageResource(R.drawable.profile)
        prname.setTextColor(getColor(R.color.purple_200))
        titlemain.setText(caritxt.text.toString())

    }

    fun searchLocation(view: View) {
        val locationSearch: EditText = findViewById<EditText>(R.id.editText)
        lateinit var location: String
        location = locationSearch.text.toString()
        var addressList: List<Address>? = null

        if (location == null || location == "") {
            Toast.makeText(applicationContext,"provide location", Toast.LENGTH_SHORT).show()
        }
        else{
            val geoCoder = Geocoder(this)
            try {
                addressList = geoCoder.getFromLocationName(location, 1)

            } catch (e: IOException) {
                e.printStackTrace()
            }
            val address = addressList!![0]
            val latLng = LatLng(address.latitude, address.longitude)
            mMap!!.addMarker(MarkerOptions().position(latLng).title(location))
            mMap!!.animateCamera(CameraUpdateFactory.newLatLng(latLng))
            Toast.makeText(applicationContext, address.latitude.toString() + " " + address.longitude, Toast.LENGTH_LONG).show()
        }
    }
}