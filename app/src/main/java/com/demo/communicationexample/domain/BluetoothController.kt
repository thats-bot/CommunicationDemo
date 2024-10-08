package com.demo.communicationexample.domain

import com.demo.communicationexample.domain.entities.BluetoothDeviceDomain
import com.demo.communicationexample.domain.entities.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface BluetoothController {

    val isConnected: StateFlow<Boolean>
    val scannedDevices: StateFlow<Set<BluetoothDeviceDomain>>
    val pairedDevices: StateFlow<Set<BluetoothDeviceDomain>>
    val error: SharedFlow<String>
    val isDiscovering: StateFlow<Boolean>
    val isDiscoveringFinished: StateFlow<Boolean>

    fun startDiscovery()
    fun stopDiscovery()

    suspend fun trySendMessage(message: String): Message?

    fun startBluetoothServer(): Flow<ConnectionResult>
    fun connectToDevice(device: BluetoothDeviceDomain): Flow<ConnectionResult>
    fun closeConnection()

    fun release()
}
