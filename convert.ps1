$OutputEncoding = [System.Text.Encoding]::UTF8

$data = import-csv ".\country_co2_by_years.CSV" -delimiter ';' -Encoding UTF8
$filepath = ".\country_export.txt"
foreach ($row in $data)
{
    $members = $row | Get-Member -MemberType NoteProperty
    foreach ($member in $members)
    {
        if ($member.Name -ne "Country")
        {
            $year = $row."$( $member.Name )".replace(",",".")
            $random = 1,4,5,6,7,8 | Get-Random

            "($random, '$( $row.country )', $( $member.Name ), NOW(), NOW(), $year)," | out-file $filepath -Append
        }
    }
}