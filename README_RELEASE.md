ACADEMIX — Release packaging instructions
======================================

This file explains how to prepare the packaged app-image for a GitHub Release. You previously provided a compressed app-image at:

    D:\tan\complete projects\ACADEMIX (ALL-FILES)\target\dist\ACADEMIX.rar

Goal
----
Produce a single ZIP file containing the app-image folder so it can be attached to a GitHub Release (recommended name: `ACADEMIX-app-image.zip`).

Recommended steps (automated, run on the build machine)
------------------------------------------------------

1) If 7‑Zip is NOT installed, install it (or use an equivalent RAR extractor):

```powershell
# Install with winget (Windows 10/11)
winget install --id=7zip.7zip -e
```

2) Extract the RAR to a temporary folder and create the ZIP:

```powershell
# Choose a temp folder
$src = 'D:\tan\complete projects\ACADEMIX (ALL-FILES)\target\dist\ACADEMIX.rar'
$temp = 'D:\temp\ACADEMIX-release'
Remove-Item -LiteralPath $temp -Recurse -Force -ErrorAction SilentlyContinue
New-Item -ItemType Directory -Path $temp | Out-Null

# Use 7z to extract (7z must be on PATH)
7z x -y "$src" -o"$temp"

# Compress the extracted folder into a single zip
$zipOut = 'D:\tan\OOP\adxnew\releases\ACADEMIX-app-image.zip'
New-Item -ItemType Directory -Path 'D:\tan\OOP\adxnew\releases' -Force | Out-Null
Compress-Archive -Path "$temp\*" -DestinationPath $zipOut -Force

# Clean up temp folder when done
Remove-Item -LiteralPath $temp -Recurse -Force
```

Notes:
- If `7z` is not installed and you prefer a GUI, you can extract the RAR with WinRAR or 7-Zip manually, then create a ZIP in Explorer (right-click -> Send to -> Compressed (zipped) folder).
- On some systems `7z` is named `7za` or `7zr`; adjust the command accordingly.

Uploading the ZIP to GitHub Release (manual)
-------------------------------------------
1. Go to https://github.com/patalMode/ACADEMIX/releases/new
2. Fill release title and notes, attach the `ACADEMIX-app-image.zip` file created above.
3. Publish release.

Uploading via GitHub CLI (`gh`) — optional
-------------------------------------------
If you have `gh` installed and authenticated, you can create a release and upload the ZIP:

```powershell
# Create a draft release (tag example: v1.0.0)
gh release create v1.0.0 .\releases\ACADEMIX-app-image.zip -t "v1.0.0" -n "ACADEMIX app-image"
```

How to test the released app-image (on clean Windows VM)
-------------------------------------------------------
1. Download and extract the ZIP on the clean Windows machine.
2. Open PowerShell, change directory to the extracted folder and run:

```powershell
cd C:\path\to\ACADEMIX
.\ACADEMIX.exe
```

Expected: the application launches without requiring Java to be installed because the runtime is bundled inside the `runtime` folder.

If you want me to prepare the zip here on this machine, I can do that — but I need either:
- the RAR to be accessible from this workspace (you provided the path already), and 7‑Zip installed on this machine; or
- permission to install 7‑Zip via `winget` so I can extract and re-zip for you.

If you prefer, I already copied the RAR into a `releases` folder and can upload the RAR directly as an artifact, but GitHub users expect a ZIP with the extracted app-image. Tell me whether you want me to install 7‑Zip here and proceed, or whether you will run the extraction locally and upload the ZIP yourself.
