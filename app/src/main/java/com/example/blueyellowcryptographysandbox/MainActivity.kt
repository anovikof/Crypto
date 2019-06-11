package com.example.blueyellowcryptographysandbox

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import com.iit.certificateAuthority.endUser.libraries.signJava.EndUser
import com.iit.certificateAuthority.endUser.libraries.signJava.EndUserPrivateKeyInfo

import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            generateKeys()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun generateKeys() {
        val endUser = EndUser()

//        copySettingsFile();

        endUser.SetUIMode(false)
        endUser.SetLanguage(EndUser.EU_EN_LANG)
        endUser.Initialize()
        endUser.SetCharset("UTF-16LE")
        endUser.SetUIMode(false)


        val keySpec: Int
        val uaKeySpec: Int
        val rsaKeySpec: Int
        val keyMediaTypeIndex: Int
        val keyMediaDeviceIndex: Int
        val keyMediaType: String
        val keyMediaDevice: String
        val keyMediasPassword: String

//        keyMediaTypeIndex = 0;
//        while (!(keyMediaType = endUser.EnumKeyMediaTypes(
//                keyMediaTypeIndex)).equals("")) {
//            EndUserUtils.printMessage(
//                    keyMediaTypeIndex + ". " + keyMediaType);
//
//            keyMediaDeviceIndex = 0;
//            while (!(keyMediaDevice = endUser.EnumKeyMediaDevices(
//                    keyMediaTypeIndex, keyMediaDeviceIndex)).equals("")) {
//                EndUserUtils.printMessage(
//                        "\t" + keyMediaDeviceIndex + ". " + keyMediaDevice);
//
//                keyMediaDeviceIndex++;
//            }
//
//            keyMediaTypeIndex++;
//        }
//
//        if (keyType == null) {
//            EndUserUtils.printMessage("Enter key type (1 - UA, 2 - RSA, 3 - UA+RSA):");
//            keySpec = Integer.parseInt(EndUserUtils.readMessage());
//        } else if (keyType.equals("UA")) {
//            keySpec = 1;
//        } else if (keyType.equals("RSA")) {
//            keySpec = 2;
//        } else if (keyType.equals("UA+RSA")) {
//            keySpec = 3;
//        } else {
//            keySpec = 0;
//        }
//
//        EndUserUtils.printMessage("Enter key media type index:");
//        keyMediaTypeIndex = Integer.parseInt(EndUserUtils.readMessage());
//        EndUserUtils.printMessage("Enter key media device index:");
//        keyMediaDeviceIndex = Integer.parseInt(EndUserUtils.readMessage());
//        EndUserUtils.printMessage("Enter key media password:");
//        keyMediasPassword = EndUserUtils.readMessage();
//
//        EndUserUtils.printMessage("Generating private key...");
//
//        switch (keySpec) {
//            case 1:
//                uaKeySpec = EndUser.EU_KEYS_TYPE_DSTU_AND_ECDH_WITH_GOSTS;
//                rsaKeySpec = EndUser.EU_KEYS_TYPE_NONE;
//                break;
//
//            case 2:
//                uaKeySpec = EndUser.EU_KEYS_TYPE_NONE;
//                rsaKeySpec = EndUser.EU_KEYS_TYPE_RSA_WITH_SHA;
//                break;
//
//            case 3:
//                uaKeySpec = EndUser.EU_KEYS_TYPE_DSTU_AND_ECDH_WITH_GOSTS;
//                rsaKeySpec = EndUser.EU_KEYS_TYPE_RSA_WITH_SHA;
//                break;
//
//            default:
//                uaKeySpec = EndUser.EU_KEYS_TYPE_NONE;
//                rsaKeySpec = EndUser.EU_KEYS_TYPE_NONE;
//                break;
//        }

        val info = EndUserPrivateKeyInfo()

        val requests = endUser.GeneratePrivateKey(
            "12345",
            EndUser.EU_KEYS_TYPE_NONE, EndUser.EU_KEYS_LENGTH_DS_UA_257, false,
            EndUser.EU_KEYS_LENGTH_KEP_UA_431, "", EndUser.EU_KEYS_TYPE_RSA_WITH_SHA,
            EndUser.EU_KEYS_LENGTH_DS_RSA_2048, "", info
        )



        val rootFolder = applicationContext.getExternalFilesDir("/")
        val keyDat = File(rootFolder, "Key-6.dat")


        for (request in requests) {
            //            if (EndUserUtils.writeFile(request.GetDefaultRequestFileName(), request.GetRequest()))
            //                EndUserUtils.printMessage(request.GetDefaultRequestFileName());
        }

//        endUser.GetJKSPrivateKey()

        var i = 0
        i++
    }
}
