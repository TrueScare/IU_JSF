$data = import-csv ".\country_co2_by_years.CSV" -delimiter ';'
$filepath = ".\country_export.csv"
"country;year;emission" | Out-File $filepath
foreach ($row in $data)
{
    $members = $row | Get-Member -MemberType NoteProperty
    foreach ($member in $members)
    {
        if ($member.Name -ne "Country")
        {
            $row.country + ";" + $member.Name + ";" + $row."$( $member.Name)" | out-file $filepath -Append
        }
    }
}